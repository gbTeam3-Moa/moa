package com.app.moa.controller.qa_post;

import com.app.moa.domain.qa_post.QaPostDTO; // Q&A 게시글 DTO
import com.app.moa.domain.post.Pagination; // 페이징 처리용 클래스
import com.app.moa.domain.qa_post.QaPostVO;
import com.app.moa.service.qa_post.QaPostService; // Q&A 게시글 서비스
import jakarta.servlet.http.HttpSession; // HTTP 세션
import lombok.RequiredArgsConstructor; // 생성자 자동 생성
import lombok.extern.slf4j.Slf4j; // 로깅
import org.springframework.stereotype.Controller; // 스프링 MVC 컨트롤러
import org.springframework.ui.Model; // 모델 객체
import org.springframework.web.bind.annotation.GetMapping; // GET 요청 처리
import org.springframework.web.bind.annotation.PostMapping; // POST 요청 처리
import org.springframework.web.bind.annotation.RequestMapping; // 요청 경로 매핑
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView; // 리다이렉트 뷰

import java.util.List; // 리스트
import java.util.Optional; // Optional

@Controller // 이 클래스가 컨트롤러임을 나타냄
@RequestMapping("/qa/*") // QA 관련 요청을 처리
@RequiredArgsConstructor // 생성자 자동 생성
@Slf4j // 로깅 기능 추가
public class QaPostController {
    private final QaPostService qaPostService; // Q&A 게시글 서비스
    private final HttpSession session; // HTTP 세션

    @GetMapping("qa-list") // Q&A 게시글 목록 조회
    public String getList(Pagination pagination, Model model, @RequestParam(defaultValue = "recent") String view) {
        pagination.setTotal(qaPostService.getTotal()); // 전체 게시글 수 설정
        pagination.progress(); // 페이지 진행 상태 업데이트
        List<QaPostDTO> posts = qaPostService.getList(pagination); // 게시글 목록 조회

        if (posts.isEmpty()) { // 게시글이 없는 경우
            log.info("포스트 없음"); // 로그에 정보 기록
        }

        model.addAttribute("pagination", pagination); // 모델에 페이징 정보 추가
        model.addAttribute("posts", posts); // 모델에 게시글 목록 추가

        return "qa/qa-list"; // Q&A 목록 페이지로 이동
    }

    // Q&A 글 작성 페이지 이동
    @GetMapping("qa-write")
    public String goToWriteForm() {
        return "qa/qa-write"; // Q&A 게시글 작성 폼
    }

    @PostMapping("qa-write")
    public RedirectView goToWrite(QaPostDTO qaPostDTO) {
        qaPostDTO.setMemberId(1L); // 임시로 회원 ID 설정
        qaPostDTO.setPostType(2); // 게시글 타입 설정
        log.info("Received QaPostDTO: {}", qaPostDTO);

        // 필수 데이터 검증
        if (qaPostDTO.getPostTitle() == null || qaPostDTO.getPostContent() == null) {
            log.error("필수 데이터가 없습니다.");
            return new RedirectView("/qa/qa-write"); // 다시 작성 페이지로 리다이렉트
        }

        // 데이터베이스에 게시글 저장
        qaPostService.write(qaPostDTO); // DTO를 VO로 변환하여 저장

        return new RedirectView("/qa/qa-list"); // 게시글 목록으로 리다이렉트
    }


    // 글 조회
    @GetMapping("qa-inquiry") // 게시글 조회
    public String getQaInquiry(@RequestParam("postId") Long postId, Model model) {
        Optional<QaPostVO> post = qaPostService.getById(postId);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
        } else {
            return "redirect:/qa/qa-list"; // 게시글이 없을 경우 목록으로 리다이렉트
        }

        log.info(String.valueOf(post.get()));
        return "qa/qa-inquiry"; // Q&A 조회 페이지로 이동
    }


}

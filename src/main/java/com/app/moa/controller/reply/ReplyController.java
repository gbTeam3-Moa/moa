package com.app.moa.controller.reply;

import com.app.moa.domain.post.Pagination; // 게시물 페이징 관련 클래스
import com.app.moa.domain.reply.ReplyDTO; // 댓글 데이터 전송 객체
import com.app.moa.service.reply.ReplyService; // 댓글 서비스 클래스
import lombok.RequiredArgsConstructor; // 생성자 주입을 위한 어노테이션
import lombok.extern.slf4j.Slf4j; // 로깅을 위한 어노테이션
import org.springframework.ui.Model; // 스프링의 모델 객체
import org.springframework.web.bind.annotation.*; // 스프링의 웹 어노테이션들

import java.util.List;

@RestController // 이 클래스가 RESTful API의 컨트롤러임을 나타냄
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 주입하는 생성자를 생성
@RequestMapping("/replies/*") // 기본 URL 매핑
@Slf4j // 로깅 기능 추가
public class ReplyController {
    private final ReplyService replyService; // 댓글 서비스 클래스의 의존성 주입

    // 댓글 작성 메소드
    @PostMapping("write")
    public void write(@RequestBody ReplyDTO replyDTO) {
        // 댓글 DTO를 VO로 변환하여 서비스에 전달
        replyService.write(replyDTO.toVO());
    }

    // 댓글 목록 조회 메소드
    @GetMapping("{postId}/{page}")
    public List<ReplyDTO> getList(@PathVariable("postId") Long postId,
                                  @PathVariable("page") int page,
                                  Pagination pagination, // 게시물 페이징 정보
                                  Model model) {
        log.info("{}", page); // 현재 페이지 로그 출력
        pagination.setPage(page); // 페이지 설정
        pagination.setTotal(replyService.getTotal(postId)); // 총 댓글 수 설정
        pagination.progress(); // 페이지 진행 상태 계산
        log.info("{}", pagination.toString()); // 페이징 정보 로그 출력

        // 댓글 목록을 조회하여 반환
        return replyService.getReplies(pagination, postId);
    }

    // 댓글 수정 메소드 (전체 수정)
    @PutMapping("update")
    public void update(@RequestBody ReplyDTO replyDTO) {
        // 댓글 DTO를 VO로 변환하여 서비스에 전달
        replyService.setReply(replyDTO.toVO());
    }

    // 댓글 삭제 메소드
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        // 주어진 ID의 댓글 삭제
        replyService.delete(id);
    }
}

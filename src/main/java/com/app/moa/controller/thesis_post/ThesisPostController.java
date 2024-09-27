package com.app.moa.controller.thesis_post;

import com.app.moa.domain.member.MemberVO;
import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import com.app.moa.service.thesis_post.ThesisPostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/thesis/*")
@RequiredArgsConstructor
@Slf4j
public class ThesisPostController {
    private final ThesisPostService thesisPostService;
    private final HttpSession session;

    @GetMapping("thesis-list")
    public String getList(Pagination pagination, Model model) {

        pagination.setTotal(thesisPostService.getTotal());
        pagination.progress();
        List<ThesisPostDTO> posts = thesisPostService.getList(pagination);

        if (posts.isEmpty()) {
            log.info("포스트 없음");
        }

        model.addAttribute("pagination", pagination);
        model.addAttribute("posts", posts);

        return "thesis/thesis-list";
    }


    // 글 작성 페이지 이동1
    @GetMapping("thesis-write1")
    public String getToWriteForm1(ThesisPostDTO thesisPostDTO) {
        return "thesis/thesis-write1";
    }

    // 글 작성 처리1
    @PostMapping("thesis-write1")
    public RedirectView thesisWrite1(ThesisPostDTO thesisPostDTO) {
//        MemberVO memberVO = (MemberVO) session.getAttribute("loginMember");
//
//        // 로그인 안되어 있으면 로그인으로 보내기
//        if (memberVO == null) {
//            return new RedirectView("/member/login");
//        }
//        thesisPostDTO.setMemberId(memberVO.getId());

        // 1단계 데이터 임시 저장 후 2단계 페이지로 이동
//        session.setAttribute("thesisPost", thesisPostDTO);
        return new RedirectView("/thesis/thesis-write2");
    }

    // 글 작성 페이지 이동2
    @GetMapping("thesis-write2")
    public String getToWriteForm2(ThesisPostDTO thesisPostDTO) {
        return "thesis/thesis-write2";
    }

    // 글 작성 처리2
    @PostMapping("thesis-write2")
    public RedirectView thesisWrite2(ThesisPostDTO thesisPostDTO) {
        // 세션에 저장된 1단계 데이터 불러오고
//        ThesisPostDTO thesisPost1Data = (ThesisPostDTO) session.getAttribute("thesisPost");

        // 2단계 데이터와 합쳐서 저장
//        thesisPost1Data.setResearchSchedule(thesisPostDTO.getResearchSchedule());
//        thesisPost1Data.setResearchRequirement(thesisPostDTO.getResearchRequirement());

        // 진짜 저장
//        thesisPostService.write(thesisPost1Data);

        return new RedirectView("/thesis/thesis-list");
    }

    @GetMapping("/thesis/thesis-inquiry")
    public String getThesisInquiry(@RequestParam("postId") Long postId, Model model) {
        Optional<ThesisPostVO> post = thesisPostService.getById(postId);
        model.addAttribute("post", post);
        return "thesis/thesis-inquiry";
    }
}

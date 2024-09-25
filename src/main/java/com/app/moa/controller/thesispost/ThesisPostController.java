package com.app.moa.controller.thesispost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.thesispost.ThesisPostDTO;
import com.app.moa.domain.user.UserVO;
import com.app.moa.service.thesispost.ThesisPostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/thesis/*")
@RequiredArgsConstructor
@Slf4j
public class ThesisPostController {
    private final ThesisPostService thesisPostService;
    private final HttpSession session;

    // 리스트 조회
    @GetMapping("thesis-list")
    public void getList(Pagination pagination, Model model) {
        pagination.setTotal(thesisPostService.getTotal());
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("posts", thesisPostService.getList(pagination));
    }
//    리스트 ID로 조회

    // 글 작성 페이지 이동
    @GetMapping("thesis-write1")
    public void getToWriteForm1(ThesisPostDTO thesisPostDTO) {
        ;
    }
    // 글 작성 처리
    @PostMapping("thesis-write1")
    public RedirectView thesisWrite1(ThesisPostDTO thesisPostDTO) {
        UserVO userVO = (UserVO) session.getAttribute("loginUser");

    // 로그인 안되어 있으면 로그인 페이지로 이동
        if (userVO == null) {
            return new RedirectView("/user/login");
        }

        thesisPostDTO.setUserId(userVO.getId());

        thesisPostService.write(thesisPostDTO);

        return new RedirectView("/thesis/thesis-write2");
    }

    @PostMapping("thesis-write2")
    public RedirectView thesisWrite2(ThesisPostDTO thesisPostDTO) {

        thesisPostService.write(thesisPostDTO);

        return new RedirectView("/thesis/list");
    }
}
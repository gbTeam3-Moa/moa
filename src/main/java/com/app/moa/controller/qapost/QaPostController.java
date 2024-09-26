package com.app.moa.controller.qapost;

import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.post.Pagination;
import com.app.moa.service.qapost.QaPostService;
import com.app.moa.service.thesispost.ThesisPostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qa/*")
@RequiredArgsConstructor
@Slf4j
public class QaPostController {
    private final QaPostService qaPostService;

    @GetMapping("qa-list")
    public void getList(Pagination pagination, Model model) {
        pagination.setTotal(qaPostService.getTotal());
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("posts", qaPostService.getList(pagination));
    }

    @GetMapping("write")
    public void goToWriteForm(QaPostDTO qapostDTO){;}

    @PostMapping("write")
    public void write(QaPostDTO qapostDTO){
        qapostDTO.setMemberId(((MemberVO) session.getAttribute("member")).getId());

        qaPostService.write(qapostDTO.toVO());
    }
}

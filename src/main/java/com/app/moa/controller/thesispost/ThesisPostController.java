package com.app.moa.controller.thesispost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.service.thesispost.ThesisPostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thesis/*")
@RequiredArgsConstructor
public class ThesisPostController {
    private final ThesisPostService thesisPostService;

    @GetMapping("thesis-list")
    public void getList(Pagination pagination, Model model) {
        pagination.setTotal(thesisPostService.getTotal());
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("posts", thesisPostService.getList(pagination));
    }
}

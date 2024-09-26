package com.app.moa.controller.thesis_post;

import com.app.moa.domain.post.Pagination;
<<<<<<< HEAD:src/main/java/com/app/moa/controller/thesispost/ThesisPostController.java
import com.app.moa.service.thesispost.ThesisPostService;

=======
import com.app.moa.service.thesis_post.ThesisPostService;
>>>>>>> master:src/main/java/com/app/moa/controller/thesis_post/ThesisPostController.java
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

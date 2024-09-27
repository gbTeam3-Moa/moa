
package com.app.moa.controller.qa_post;

import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.domain.post.Pagination;
import com.app.moa.service.qa_post.QaPostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/qa/*")
@RequiredArgsConstructor
@Slf4j
public class QaPostController {
    private final QaPostService qaPostService;
    private final HttpSession session;

    @GetMapping("qa-list")
    public String getList(Pagination pagination, Model model) {
        pagination.setTotal(qaPostService.getTotal());
        pagination.progress();
        List<QaPostDTO> posts = qaPostService.getList(pagination);

        if (posts.isEmpty()) {
            log.info("포스트 없음");
        }

        model.addAttribute("pagination", pagination);
        model.addAttribute("posts", posts);

        return "qa/qa-list";
    }

    @GetMapping("qa-write")
    public void goToWriteForm(QaPostDTO qapostDTO){;}

    @PostMapping("qa-write")
    public RedirectView goToListForm(Pagination pagination, Model model){
        pagination.setTotal(qaPostService.getTotal());
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("posts", qaPostService.getList(pagination));
        return new RedirectView("/qa/qa-list");
    }

    @GetMapping("qa-inquiry")
    public void goTOReadForm(QaPostDTO qapostDTO){;}

}


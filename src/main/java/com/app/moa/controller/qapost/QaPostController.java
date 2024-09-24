package com.app.moa.controller.qapost;

import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.post.Pagination;
import com.app.moa.service.qapost.QaPostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qapost/*")
@RequiredArgsConstructor
@Slf4j
public class QaPostController {
    private final QaPostService qaPostService;
    private final HttpSession session;
    private final QaPostDTO qaPostDTO;

    @GetMapping("write")
    public void goToWriteForm(QaPostDTO qaPostDTO){;}

    @PostMapping("write")
    public void write(QaPostDTO qaPostDTO) {
        qaPostDTO.setPostId(((PostVO) session.getAttribute("post")).getId());

        qaPostService.write(qaPostDTO.toVO());
    }

        @GetMapping("list")
        public void getList (Pagination pagination, String order, Model model){
            if (order == null) {
                order = "recent";
            }
            pagination.setTotal(qaPostService.getTotal());
            pagination.progress();
            model.addAttribute("posts", qaPostService.getList(pagination, order));
        }

}


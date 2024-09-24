package com.app.moa.controller.post;


import com.app.moa.domain.post.PostDTO;
import com.app.moa.service.post.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    private final HttpSession session;

    @GetMapping("write")
    public void goToWriteForm(PostDTO postDTO){;}

    @PostMapping("write")
    public void write(PostDTO postDTO){
        postDTO.setUserId(((UserVO) session.getAttribute("user")).getId());

        postService.write(postDTO.toVO());
    }

}

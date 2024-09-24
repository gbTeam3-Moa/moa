package com.app.moa.controller.post;


import com.app.moa.domain.post.PostDTO;
import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.user.UserVO;
import com.app.moa.service.post.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

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
    @GetMapping(value = {"read"})
    public void goToReadForm(Long id, Model model, HttpSession session){
        postService.increaseViewCountPost(id);
        PostVO postVO = (PostVO) session.getAttribute("post");
        model.addAttribute("post", postVO);
    }

    @GetMapping(value = { "update"})
    public void goToUpdateForm(Model model, HttpSession session){
        PostVO postVO = (PostVO) session.getAttribute("post");
        model.addAttribute("post", postVO);
    }

    @PostMapping("update")
    public RedirectView update(PostDTO postDTO){
        log.info(postDTO.toString());
        postService.updatePost(postDTO.toVO());
        return new RedirectView("/post/read/" + postDTO.getId());
    }
    @PostMapping("delete/{id}")
    public RedirectView delete(@PathVariable Long id){
        postService.deletePost(id);
        log.info("게시글이 삭제되었습니다. ID: " + id);
        return new RedirectView("/post/list");  // 삭제 후 게시글 목록 페이지로 리다이렉트 후 확인할 수 있게
    }

    @GetMapping("delete")
    public RedirectView delete(Long id){
        postService.deletePost(id);
        return new RedirectView("/post/login");
    }
}

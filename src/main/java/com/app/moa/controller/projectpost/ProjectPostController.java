//package com.app.moa.controller.projectpost;
//
//import com.app.moa.domain.projectpost.ProjectPostDTO;
//import com.app.moa.service.post.PostService;
//import com.app.moa.service.projectpost.ProjectPostService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/post/project/*")
//@Slf4j
//public class ProjectPostController {
//
//    private final PostService postService;
//    private final ProjectPostService projectPostService;
//
//    // 조회 기능 - 테이블 형태로 데이터를 출력해야하고 제목 부분에는 TBL_POST의 POST_TITLE, 내용에는 POST_CONTENT
//    // 그리고 그 밑에는 TBL_PROJECT_POST의 PROJECT_FIELD와 PROJECT_REQUIREMENT를 가져오려 함
//    @GetMapping("/read/{id}")
//    public String getProjectPostById(@PathVariable Long id, Model model) {
//        // TBL_POST에서 POST_TITLE, POST_CONTENT 가져오기
//        PostDTO postDTO = postService.findById(id);
//        model.addAttribute("postTitle", postDTO.getPostTitle());
//        model.addAttribute("postContent", postDTO.getPostContent());
//
//        // TBL_PROJECT_POST에서 PROJECT_FIELD, PROJECT_REQUIREMENT 가져오기
//        ProjectPostDTO projectPostDTO = projectPostService.findById(id);
//        model.addAttribute("projectField", projectPostDTO.getProjectField());
//        model.addAttribute("projectRequirement", projectPostDTO.getProjectRequirement());
//
//        return "";  //여기로
//    }
//
//}
package com.app.moa.mapper;

import com.app.moa.domain.post.PostDTO;
import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.mapper.projectpost.ProjectPostMapper;
import com.app.moa.service.post.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectPostTests {

    @Autowired
    private ProjectPostMapper projectPostMapper;

    @Autowired
    private PostService postService;

    @Test
    public void testInsert() {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostTitle("프로젝트 제목");
        postDTO.setPostContent("프로젝트 내용");
        postDTO.setPostType(3);
        postDTO.setUserId(1L);
        postService.write(postDTO.toVO());

        Long postId = postDTO.getId();

        log.info("TBL_POST에 삽입된 ID: " + postId);
        if (postId == null) {
            log.info("ID 없음");
            return;
        }

        ProjectPostDTO projectPostDTO = new ProjectPostDTO();
        projectPostDTO.setId(postId);
        projectPostDTO.setStudentMajor("컴퓨터 공학");
        projectPostDTO.setProjectField("소프트웨어 개발");
        projectPostDTO.setProjectProfit("수익 없음");
        projectPostDTO.setProjectPeriod("6개월");
        projectPostDTO.setProjectDeadline("2024-12-31");
        projectPostDTO.setProjectStartDate("2024-06-01");
        projectPostDTO.setProjectSchedule("주간 회의");
        projectPostDTO.setProjectRequirement("SpringBoot");

        projectPostMapper.insert(projectPostDTO.toVO());
        log.info("프로젝트 포스트가 추가 되었습니다: " + projectPostDTO);
    }




    @Test
    public void testSelectById() {
        Long id = 1L;
        ProjectPostDTO projectPostDTO = projectPostMapper.selectById(id);

        log.info("조회된 프로젝트 포스트: " + projectPostDTO);
    }

    @Test
    public void testUpdate() {
        ProjectPostDTO projectPostDTO = new ProjectPostDTO();
        projectPostDTO.setId(1L);
        projectPostDTO.setStudentMajor("수정된 전공");
        projectPostDTO.setProjectField("수정된 프로젝트 필드");
        projectPostDTO.setProjectProfit("수정된 수익");
        projectPostDTO.setProjectPeriod("수정된 기간");
        projectPostDTO.setProjectDeadline("2024-11-30");
        projectPostDTO.setProjectStartDate("2024-05-01");
        projectPostDTO.setProjectSchedule("수정된 일정");
        projectPostDTO.setProjectRequirement("수정된 요구사항");

        projectPostMapper.updateById(projectPostDTO);
        log.info("프로젝트 포스트가 수정되었습니다: " + projectPostDTO);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        projectPostMapper.deleteById(id);
        log.info("프로젝트 포스트가 삭제되었습니다. ID: " + id);
    }
}

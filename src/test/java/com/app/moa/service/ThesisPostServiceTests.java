package com.app.moa.service;

import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import com.app.moa.service.thesis_post.ThesisPostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class ThesisPostServiceTests {
    @Autowired
    private ThesisPostService thesisPostService;
    @Autowired
    private ThesisPostDTO thesisPostDTO;


    @Test
    public void testInsert() {
        ThesisPostDTO thesisPostDTO = new ThesisPostDTO();
        thesisPostDTO.setPostTitle("논문 제목2");
        thesisPostDTO.setPostContent("논문 내용2");
        thesisPostDTO.setMemberId(21L);
        thesisPostDTO.setPostView(120);
        thesisPostDTO.setProfessorMajor("수학과");
        thesisPostDTO.setResearchField("분야");
        thesisPostDTO.setResearchProfit("없음");
        thesisPostDTO.setResearchPeriod("6개월");
        thesisPostDTO.setResearchDeadline("2024-12-31");
        thesisPostDTO.setResearchStartDate("2024-06-01");
        thesisPostDTO.setResearchSchedule("스케쥴");
        thesisPostDTO.setResearchRequirement("AI 개발자");

        thesisPostService.write(thesisPostDTO);
    }

    @Test
    public void testDelete() {
        Long id = 81L;
        thesisPostService.delete(id);
        log.info("Deleted post with ID: {}", id);
    }

    @Test
    public void testUpdate() {
        ThesisPostDTO thesisPostDTO = new ThesisPostDTO();
        thesisPostDTO.setPostTitle("제목3333");
        thesisPostDTO.setPostContent("내용3333");
        thesisPostDTO.setId(146L);
        thesisPostDTO.setProfessorMajor("전공2");
        thesisPostDTO.setResearchField("분야2");
        thesisPostDTO.setResearchProfit("없음1");
        thesisPostDTO.setResearchPeriod("8개월");
        thesisPostDTO.setResearchDeadline("2024-12-31");
        thesisPostDTO.setResearchStartDate("2024-06-01");
        thesisPostDTO.setResearchSchedule("스케쥴");
        thesisPostDTO.setResearchRequirement("자바 개발자");
        thesisPostService.update(thesisPostDTO.toVO());
    }

    @Test
    public void testSelectById() {
        Long id = 146L;

        thesisPostService.getById(id);

        if (thesisPostDTO != null) {
            log.info("Selected post with ID: {}", thesisPostDTO.getId());
            log.info("Post Title: {}", thesisPostDTO.getPostTitle());
            log.info("Post Content: {}", thesisPostDTO.getPostContent());
            log.info("Member ID: {}", thesisPostDTO.getMemberId());
        } else {
            log.warn("No post found with ID: {}", id);
        }
    }

}

package com.app.moa.service;

import com.app.moa.domain.report.ReportDTO;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.service.report.ReportService;
import com.app.moa.service.thesis_post.ThesisPostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReportServiceTests {
    @Autowired
    private ThesisPostService thesisPostService;
    @Autowired
    private ThesisPostDTO thesisPostDTO;
    @Autowired
    private ReportService reportService;
    @Autowired
    private ReportDTO reportDTO;


//    @Test
//    public void testInsert() {
//        ThesisPostDTO thesisPostDTO = new ThesisPostDTO();
//        thesisPostDTO.setPostTitle("논문 제목2");
//        thesisPostDTO.setPostContent("논문 내용2");
//        thesisPostDTO.setMemberId(21L);
//        thesisPostDTO.setPostView(100);
//        thesisPostDTO.setProfessorMajor("수학과");
//        thesisPostDTO.setResearchField("분야");
//        thesisPostDTO.setResearchProfit("없음");
//        thesisPostDTO.setResearchPeriod("6개월");
//        thesisPostDTO.setResearchDeadline("2024-12-31");
//        thesisPostDTO.setResearchStartDate("2024-06-01");
//        thesisPostDTO.setResearchSchedule("스케쥴");
//        thesisPostDTO.setResearchRequirement("AI 개발자");
//
//        thesisPostService.write(thesisPostDTO);
//    }
//
//    @Test
//    public void testDelete() {
//        Long id = 81L;
//        thesisPostService.delete(id);
//        log.info("Deleted post with ID: {}", id);
//    }
//
//    @Test
//    public void testUpdate() {
//        ThesisPostDTO thesisPostDTO = new ThesisPostDTO();
//        thesisPostDTO.setPostTitle("제목3333");
//        thesisPostDTO.setPostContent("내용3333");
//        thesisPostDTO.setId(146L);
//        thesisPostDTO.setProfessorMajor("전공2");
//        thesisPostDTO.setResearchField("분야2");
//        thesisPostDTO.setResearchProfit("없음1");
//        thesisPostDTO.setResearchPeriod("8개월");
//        thesisPostDTO.setResearchDeadline("2024-12-31");
//        thesisPostDTO.setResearchStartDate("2024-06-01");
//        thesisPostDTO.setResearchSchedule("스케쥴");
//        thesisPostDTO.setResearchRequirement("자바 개발자");
//        thesisPostService.update(thesisPostDTO);
//
//        log.info("{}",thesisPostDTO);
//    }

    @Test
    public void testSelectById() {
        Long id = 121L;

        reportService.getById(id);

        if (reportDTO != null) {
            log.info("Selected post with ID: {}", reportDTO.getId());
            log.info("Post Title: {}", reportDTO.getPostTitle());
            log.info("Post Content: {}", reportDTO.getPostContent());
        } else {
            log.warn("No post found with ID: {}", id);
        }
    }

}

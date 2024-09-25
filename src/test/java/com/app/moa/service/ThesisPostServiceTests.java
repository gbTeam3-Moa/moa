package com.app.moa.service;

import com.app.moa.domain.thesispost.ThesisPostDTO;
import com.app.moa.service.thesispost.ThesisPostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ThesisPostServiceTests {
    @Autowired
    private ThesisPostService thesisPostService;


    @Test
    public void testAttach() {
        ThesisPostDTO thesisPostDTO = new ThesisPostDTO();
        thesisPostDTO.setPostTitle("제목2222");
        thesisPostDTO.setPostContent("내용22222");
        thesisPostDTO.setUserId(43L);
        thesisPostDTO.setProfessorMajor("전공1");
        thesisPostDTO.setResearchField("분야");
        thesisPostDTO.setResearchProfit("없음");
        thesisPostDTO.setResearchPeriod("6개월");
        thesisPostDTO.setResearchDeadline("2024-12-31");
        thesisPostDTO.setResearchStartDate("2024-06-01");
        thesisPostDTO.setResearchSchedule("스케쥴");
        thesisPostDTO.setResearchRequirement("자바 개발자");

        thesisPostService.write(thesisPostDTO);
    }
}

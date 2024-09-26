package com.app.moa.mapper;

import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.mapper.thesis_post.ThesisPostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ThesisPostMapperTests {

    @Autowired
    private ThesisPostMapper thesisPostMapper;
    private  ThesisPostDTO thesisPostDTO;

    @Test
    public void Inserttest() {
        ThesisPostDTO thesisPostDTO = new ThesisPostDTO();
        thesisPostDTO.setUserId(62L);
        thesisPostDTO.setPostTitle("제목입니다");
        thesisPostDTO.setPostContent("내용1");
        thesisPostDTO.setProfessorMajor("전공1");
        thesisPostDTO.setResearchField("분야");
        thesisPostDTO.setResearchProfit("없음");
        thesisPostDTO.setResearchPeriod("6개월");
        thesisPostDTO.setResearchDeadline("2024-12-31");
        thesisPostDTO.setResearchStartDate("2024-06-01");
        thesisPostDTO.setResearchRequirement("자바 개발자");
    }

}
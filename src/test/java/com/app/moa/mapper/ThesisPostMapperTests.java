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

        thesisPostDTO.setMemberId(62L);
        thesisPostDTO.setPostTitle("신고입니다");
        thesisPostDTO.setPostContent("신고해주세요1");
        thesisPostDTO.setProfessorMajor("가짜전공입니다1");
        thesisPostDTO.setResearchField("분야1");
        thesisPostDTO.setResearchProfit("없음1");
        thesisPostDTO.setResearchPeriod("6개월일껄?");
        thesisPostDTO.setResearchDeadline("2024-11-11");
        thesisPostDTO.setResearchStartDate("2024-08-08");
        thesisPostDTO.setResearchRequirement("자바 개발자");
    }

}
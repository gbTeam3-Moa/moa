package com.app.moa.mapper;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import com.app.moa.mapper.thesis_post.ThesisPostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Slf4j
public class ThesisPostMapperTests {

    @Autowired
    private  ThesisPostMapper thesisPostMapper;
    @Autowired
    private ThesisPostDTO thesisPostDTO;


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
    @Test
    public void testSelectById() {
       thesisPostDTO.setId(146L);

       Optional<ThesisPostVO> foundThesis = thesisPostMapper.selectById(thesisPostDTO.getId());

        log.info(foundThesis.toString());
    }

    @Test
    public void testSelectAll(){
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.setTotal(thesisPostMapper.selectCount());
        pagination.progress();
        List<ThesisPostDTO> posts = thesisPostMapper.selectAll(pagination);
        log.info("{}", posts.size());
        posts.stream().map(ThesisPostDTO::toString).forEach(log::info);
    }

}
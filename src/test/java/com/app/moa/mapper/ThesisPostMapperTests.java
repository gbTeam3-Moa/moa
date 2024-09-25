package com.app.moa.mapper;

import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.thesispost.ThesisPostDTO;
import com.app.moa.domain.thesispost.ThesisPostVO;
import com.app.moa.mapper.thesispost.ThesisPostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
@Slf4j
public class ThesisPostMapperTests {

    @Autowired
    private  ThesisPostMapper thesisPostMapper;
    @Autowired
    private ThesisPostDTO thesisPostDTO;


    @Test
    public void testSelectById() {
        Long id = 66L;
        Optional<ThesisPostVO> thesisPostDTO = thesisPostMapper.selectById(id);

        log.info("조회된 포스트: " + thesisPostDTO);
    }

}
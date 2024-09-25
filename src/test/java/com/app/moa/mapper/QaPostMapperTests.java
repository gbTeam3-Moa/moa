package com.app.moa.mapper;

import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.mapper.qapost.QaPostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class QaPostMapperTests {
    @Autowired
    private QaPostMapper qaPostMapper;

    @Test
    public void testInsert(){
        QaPostDTO qaPostDTO = new QaPostDTO();
        qaPostDTO.setPostId(1L);

//        qaPostMapper.insert(qaPostDTO.toVO());
    }
}

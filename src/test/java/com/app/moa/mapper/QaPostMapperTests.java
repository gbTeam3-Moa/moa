package com.app.moa.mapper;

import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.service.qa_post.QaPostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class QaPostMapperTests {
    @Autowired
    private QaPostService qaPostService;

    @Test
    public void testwrite() {
        QaPostDTO qaPostDTO = new QaPostDTO();

        qaPostDTO.setPostTitle("제목");
        qaPostDTO.setPostContent("내용");
        qaPostDTO.setPostType(1);
        qaPostDTO.setUserId(1L);
        qaPostService.write(qaPostDTO);

    }
}

package com.app.moa.service;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.mapper.post.PostMapper;
import com.app.moa.service.qa_post.QaPostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class QaPostServiceTests {
    @Autowired
    private QaPostService qaPostService;
    @Autowired
    private PostMapper postMapper;

    @Test
    public void testwrite() {
        QaPostDTO qaPostDTO = new QaPostDTO();
        qaPostDTO.setId(1L);
        qaPostDTO.setPostTitle("제목ㅇㅇddd");
        qaPostDTO.setPostContent("내용ㅇㅇddd");
        qaPostDTO.setPostType(1);
        qaPostDTO.setMemberId(50L);

        qaPostService.write(qaPostDTO);
    }


}

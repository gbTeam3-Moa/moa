package com.app.moa.mapper;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.mapper.qapost.QaPostMapper;
import com.app.moa.service.qapost.QaPostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class QaPostMapperTests {
    @Autowired
    private QaPostMapper qaPostMapper;
    @Autowired
    private QaPostDTO qaPostDTO;

    @Test
    public void testwrite() {
        QaPostDTO qaPostDTO = new QaPostDTO();
        qaPostDTO.setId(1L);
        qaPostDTO.setPostTitle("제목");
        qaPostDTO.setPostContent("내용1");
        qaPostDTO.setPostType(1);
        qaPostDTO.setUserId(1L);
        qaPostMapper.insert(qaPostDTO.toVO());
    }
    @Test
    public void testSelectAll(){
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.setTotal(qaPostMapper.selectCount());
        pagination.progress();
        List<QaPostDTO> posts = qaPostMapper.selectAll(pagination);
        log.info("{}", posts.size());
        posts.stream().map(QaPostDTO::toString).forEach(log::info);
    }
}

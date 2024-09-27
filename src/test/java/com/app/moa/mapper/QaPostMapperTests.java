package com.app.moa.mapper;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.mapper.qa_post.QaPostMapper;
import com.app.moa.service.qa_post.QaPostService;
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
        qaPostDTO.setMemberId(1L);
        qaPostMapper.insert(qaPostDTO.toVO());
    }

    @Test
    public void testSelectById() {
        Long id = 168L;
        QaPostDTO qaPostDTO = qaPostMapper.selectById(id);

        log.info("조회된 q&a post: " + qaPostDTO);
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


    @Test
    public void testUpdate() {
        QaPostDTO qaPostDTO = new QaPostDTO();
        qaPostDTO.setId(142L);
        qaPostDTO.setPostTitle("제목수정");
        qaPostDTO.setPostContent("내용수정");
        qaPostDTO.setPostType(0);
        qaPostMapper.updateById(qaPostDTO);
        log.info("q&a post가 수정되었습니다: " + qaPostDTO);
    }
    @Test
    public void testDeleteById() {
        Long id = 62L;
        qaPostMapper.deleteById(id);
        log.info("프로젝트 포스트가 삭제되었습니다. ID: " + id);
    }

}

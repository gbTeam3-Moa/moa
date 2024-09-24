package com.app.moa.mapper;

import com.app.moa.domain.post.PostDTO;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.mapper.post.PostMapper;
import com.app.moa.mapper.qapost.QaPostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void testInsert() {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostTitle("title2"); // 제목 설정
        postDTO.setPostContent("content2"); // 내용 설정
        postDTO.setPostType(1); // 게시글 타입 설정 (예: 1)
        postDTO.setUserId(3L); // 사용자 ID 설정 (예: 1)
        postDTO.setPostView(0); // 조회수 초기화

        // DAO 또는 Mapper를 통해 데이터베이스에 삽입
        postMapper.insert(postDTO.toVO());
    }
    @Test
    public void testUpdate() {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(1L);
        postDTO.setPostTitle("수정된 제목");
        postDTO.setPostContent("수정된 내용");
        postDTO.setPostType(3);
        postDTO.setUserId(1L);
        postDTO.setPostView(0);

        postMapper.updateById(postDTO);
    }
    @Test
    public void testSelectById() {
        Long id = 3L;  // 테스트할 게시글 ID

        PostDTO postDTO = postMapper.selectById(id);

        log.info("조회된 게시글: " + postDTO);
    }
    @Test
    public void testDeleteById() {
        Long id = 4L;  // 삭제할 게시글 ID

        postMapper.deleteById(id);

        log.info("게시글이 삭제되었습니다. ID: " + id);
    }


}

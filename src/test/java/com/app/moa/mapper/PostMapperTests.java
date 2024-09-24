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
        postDTO.setPostTitle("title"); // 제목 설정
        postDTO.setPostContent("content"); // 내용 설정
        postDTO.setPostType(1); // 게시글 타입 설정 (예: 1)
        postDTO.setUserId(1L); // 사용자 ID 설정 (예: 1)
        postDTO.setPostView(0); // 조회수 초기화

        // DAO 또는 Mapper를 통해 데이터베이스에 삽입
        postMapper.insert(postDTO.toVO());
    }

}

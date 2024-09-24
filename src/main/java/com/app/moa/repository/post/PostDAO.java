package com.app.moa.repository.post;

import com.app.moa.domain.post.PostVO;
import com.app.moa.mapper.post.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    //    게시글 작성
    public void save(PostVO postVO) {
        postMapper.insert(postVO);
    }
}

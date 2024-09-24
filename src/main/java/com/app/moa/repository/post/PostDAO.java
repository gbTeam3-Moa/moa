package com.app.moa.repository.post;

import com.app.moa.domain.post.PostDTO;
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

    public PostDTO findById(Long id) {
        return postMapper.selectById(id);
    }

    public void update(PostDTO postDTO) {
        postMapper.updateById(postDTO);
    }

    public void delete(Long id) {
        postMapper.deleteById(id);
    }
}

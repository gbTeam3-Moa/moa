package com.app.moa.repository.post;

import com.app.moa.domain.post.PostVO;
import com.app.moa.mapper.post.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public void save(PostVO postVO) {
        postMapper.insert(postVO);
    }

    public PostVO findById(Long id) {
        return postMapper.selectById(id);
    }

    public void update(PostVO postVO) {
        postMapper.updateById(postVO);
    }

    public void delete(Long id) {postMapper.deleteById(id);}

    public void increaseViewCount(Long id){postMapper.increaseViewCountById(id);}


}

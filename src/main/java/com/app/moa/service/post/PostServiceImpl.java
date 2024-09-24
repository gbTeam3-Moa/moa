package com.app.moa.service.post;

import com.app.moa.domain.post.PostDTO;
import com.app.moa.domain.post.PostVO;
import com.app.moa.repository.post.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
    }
    @Override
    public PostDTO findById(Long id) {
        return postDAO.findById(id);
    }

    @Override
    public void updatePost(PostVO postVO) {
        postDAO.update(postVO.toDTO());
    }

    @Override
    public void deletePost(Long id) {
        postDAO.delete(id);
    }
    @Override
    public void increaseViewCountPost(Long id){
        postDAO.increaseViewCount(id);
    }

}

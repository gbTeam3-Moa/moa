package com.app.moa.service.post;

import com.app.moa.domain.post.PostDTO;
import com.app.moa.domain.post.PostVO;
import com.app.moa.repository.post.PostDAO;
import com.app.moa.repository.qapost.QaPostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class QaPostService implements PostService {
    private final PostDAO postDAO;
    private final QaPostDAO qaPostDAO;

    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
        qaPostDAO.save(postVO.getId());
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

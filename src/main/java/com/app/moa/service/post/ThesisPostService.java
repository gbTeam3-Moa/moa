package com.app.moa.service.post;


import com.app.moa.domain.post.PostDTO;
import com.app.moa.domain.post.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThesisPostService implements PostService {
    @Override
    public void write(PostVO postVO) {

    }

    @Override
    public PostDTO findById(Long id) {
        return null;
    }

    @Override
    public void updatePost(PostVO PostVO) {

    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public void increaseViewCountPost(Long id) {

    }
}

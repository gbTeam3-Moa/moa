package com.app.moa.service.post;

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
}

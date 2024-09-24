package com.app.moa.service.post;

import com.app.moa.domain.post.PostDTO;
import com.app.moa.domain.post.PostVO;

public interface PostService {
    public void write(PostVO postVO);
    public PostDTO findById(Long id);
    public void updatePost(PostVO PostVO);
    public void deletePost(Long id);

}

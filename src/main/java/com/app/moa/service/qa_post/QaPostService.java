package com.app.moa.service.qa_post;

import com.app.moa.domain.qa_post.QaPostDTO;

public interface QaPostService {
    public void write(QaPostDTO qaPostDTO);
    public QaPostDTO findById(Long id);
    public void updatePost(QaPostDTO qaPostDTO);
    public void deletePost(Long id);
}

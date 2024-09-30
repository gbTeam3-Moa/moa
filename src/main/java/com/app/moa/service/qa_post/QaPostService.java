package com.app.moa.service.qa_post;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.domain.qa_post.QaPostVO;
import com.app.moa.domain.thesis_post.ThesisPostVO;

import java.util.List;
import java.util.Optional;

public interface QaPostService {
    public void write(QaPostDTO qaPostDTO);
    public Optional<QaPostVO> getById(Long id);
    public List<QaPostDTO> getList(Pagination pagination);
    public int getTotal();
    public void update(QaPostDTO qaPostDTO);
    public void delete(Long id);

}

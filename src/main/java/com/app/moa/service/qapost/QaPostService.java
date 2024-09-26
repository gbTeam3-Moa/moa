package com.app.moa.service.qapost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.projectpost.ProjectPostVO;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.qapost.QaPostVO;
import com.app.moa.domain.thesispost.ThesisPostDTO;

import java.util.List;

public interface QaPostService {
    public void write(QaPostDTO qaPostDTO);
    public  QaPostDTO selectById(Long id);
    public List<QaPostDTO> getList(Pagination pagination);
    public int getTotal();
    public void updatePost(QaPostDTO qaPostDTO);
    public void deletePost(Long id);
}

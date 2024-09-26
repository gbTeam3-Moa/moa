package com.app.moa.service.thesis_post;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;


import java.util.List;

public interface ThesisPostService {
    public void write(ThesisPostVO thesisPostVO);
    public List<ThesisPostDTO> getList(Pagination pagination);
    public int getTotal();
}

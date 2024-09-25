package com.app.moa.service.thesispost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.qapost.QaPostVO;
import com.app.moa.domain.thesispost.ThesisPostDTO;
import com.app.moa.domain.thesispost.ThesisPostVO;

import java.util.List;

public interface ThesisPostService {
    public void write(ThesisPostVO thesisPostVO);
    public List<ThesisPostDTO> getList(Pagination pagination);
    public int getTotal();

}

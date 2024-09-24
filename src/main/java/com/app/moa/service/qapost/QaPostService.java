package com.app.moa.service.qapost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.qapost.QaPostVO;

import java.util.List;

public interface QaPostService {
    public void write(QaPostVO qaPostVO);
    public List<QaPostDTO> getList(Pagination pagination, String order);
    public int getTotal();
}

package com.app.moa.service.thesis_post;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.Search;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;


import java.util.List;
import java.util.Optional;

public interface ThesisPostService {
    public void write(ThesisPostDTO thesisPostDTO);
    public List<ThesisPostDTO> getList(Pagination pagination, Search search);
    public int getTotal();
    public int getTotalWithSearch(Search search);
    public Optional<ThesisPostVO> getById(Long id);
    public void update(ThesisPostDTO thesisPostDTO);
    public void delete(Long id);
    public void increasePostView(Long id);
}

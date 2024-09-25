package com.app.moa.service.thesispost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.thesispost.ThesisPostDTO;
import com.app.moa.domain.thesispost.ThesisPostVO;
import com.app.moa.repository.thesispost.ThesisPostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThesisPostServiceImpl implements ThesisPostService {

    private final ThesisPostDAO thesisPostDAO;
    private final ThesisPostDTO thesisPostDTO;

    @Override
    public void write(ThesisPostVO thesisPostVO) {
        PostVO postVO = thesisPostDTO.toPostVO();
    }
    @Override
    public List<ThesisPostDTO> getList(Pagination pagination) {
        return thesisPostDAO.findAll(pagination);
    }

    @Override
    public int getTotal() {
        return thesisPostDAO.findCount();
    }
}

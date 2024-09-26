package com.app.moa.service.thesis_post;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import com.app.moa.mapper.post.PostMapper;
import com.app.moa.mapper.thesis_post.ThesisPostMapper;
import com.app.moa.repository.post.PostDAO;
import com.app.moa.repository.thesis_post.ThesisPostDAO;
import com.app.moa.service.thesis_post.ThesisPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ThesisPostServiceImpl implements ThesisPostService {
    private final PostMapper postMapper;
    private final ThesisPostMapper thesisPostMapper;

    private final ThesisPostDAO thesisPostDAO;

    @Override
    public void write(ThesisPostDTO thesisPostDTO) {
        PostVO postVO = thesisPostDTO.toPostVO();

        postMapper.insert(postVO);

        thesisPostDTO.setId(postVO.getId());

        thesisPostMapper.insert(thesisPostDTO.toVO());
    }

    @Override
    public List<ThesisPostDTO> getList(Pagination pagination) {
        return thesisPostDAO.findAll(pagination);
    }

    @Override
    public int getTotal() {
        return thesisPostDAO.findCount();
    }

    @Override
    public Optional<ThesisPostVO> getById(Long id) {
        return thesisPostDAO.findById(id);
    }

    @Override
    public void update(ThesisPostVO thesisPostVO) {
        thesisPostMapper.update(thesisPostVO);
    }

    @Override
    public void delete(Long id) {
        thesisPostDAO.delete(id);

    }

    @Override
    public void increaseViewCount(Long id) {
        thesisPostMapper.increaseViewCountById(id);
    }
}

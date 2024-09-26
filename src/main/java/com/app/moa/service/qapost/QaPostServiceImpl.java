package com.app.moa.service.qapost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.qapost.QaPostVO;
import com.app.moa.domain.thesispost.ThesisPostDTO;
import com.app.moa.repository.post.PostDAO;
import com.app.moa.repository.qapost.QaPostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class QaPostServiceImpl implements QaPostService {

    private final QaPostDAO qaPostDAO;
    private final PostDAO postDAO;

    @Override
    public void write(QaPostDTO qaPostDTO) {
        PostVO postVO = qaPostDTO.toPostVO();

        postDAO.save(postVO);
        qaPostDTO.setId(postVO.getId());
        qaPostDAO.save(qaPostDTO.toVO());
    }
    @Override
    public QaPostDTO selectById(Long id) {
        return qaPostDAO.findById(id);
    }

    @Override
    public List<QaPostDTO> getList(Pagination pagination) {
        return qaPostDAO.findAll(pagination);
    }

    @Override
    public int getTotal() {
        return qaPostDAO.findCount();
    }

    @Override
    public void updatePost(QaPostDTO qaPostDTO) {
        qaPostDAO.update(qaPostDTO);
    }

    @Override
    public void deletePost(Long id) {
        qaPostDAO.delete(id);
    }
}

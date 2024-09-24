package com.app.moa.service.qapost;

import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.qapost.QaPostVO;
import com.app.moa.repository.qapost.QaPostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QaPostServiceImpl implements QaPostService {

    private final QaPostDAO qaPostDAO;

    @Override
    public void write(QaPostVO qaPostVO) {qaPostDAO.save(qaPostVO.getId());
    }

    @Override
    public QaPostDTO findById(Long id) {
        return qaPostDAO.findById(id);
    }

    @Override
    public void updatePost(QaPostDTO projectPostDTO) {
        qaPostDAO.update(projectPostDTO);
    }

    @Override
    public void deletePost(Long id) {
        qaPostDAO.delete(id);
    }
}

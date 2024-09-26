package com.app.moa.repository.qa_post;


import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.domain.qa_post.QaPostVO;
import com.app.moa.mapper.qa_post.QaPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QaPostDAO {
    private final QaPostMapper qaPostMapper;

    public void save(QaPostVO qaPostVO) {qaPostMapper.insert(qaPostVO);}

    // ID로 프로젝트 포스트 조회
    public QaPostDTO findById(Long id) {
        return qaPostMapper.selectById(id);
    }

    // ID로 프로젝트 포스트 수정
    public void update(QaPostDTO qaPostDTO) {
        qaPostMapper.updateById(qaPostDTO);
    }

    // ID로 프로젝트 포스트 삭제
    public void delete(Long id) {
        qaPostMapper.deleteById(id);
    }
}
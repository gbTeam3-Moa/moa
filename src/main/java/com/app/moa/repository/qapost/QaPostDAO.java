package com.app.moa.repository.qapost;

import com.app.moa.domain.qapost.QaPostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QaPostDAO {
    private final QaPostMappe qaPostMapper;

    //    게시글 작성
    public void save(QaPostVO qaPostVO) {
        qaPostMapper.insert(qaPostVO);
    }
}

package com.app.moa.repository.qapost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.qapost.QaPostVO;
import com.app.moa.mapper.qapost.QaPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QaPostDAO {
    private final QaPostMapper qaPostMapper;

    //    게시글 작성
    public void save(QaPostVO qaPostVO) {
        qaPostMapper.insert(qaPostVO);
    }
    //    게시글 전체 조회
    public List<QaPostDTO> findAll(Pagination pagination, String order){

        return qaPostMapper.selectAll(pagination, order);
    }
    //    게시글 전체 개수 조회
    public int getTotal(){
        return qaPostMapper.selectTotal();
    }
}

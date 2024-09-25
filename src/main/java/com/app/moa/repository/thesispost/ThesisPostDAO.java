package com.app.moa.repository.thesispost;


import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.thesispost.ThesisPostDTO;
import com.app.moa.domain.thesispost.ThesisPostVO;
import com.app.moa.mapper.thesispost.ThesisPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ThesisPostDAO {
    private final ThesisPostMapper thesisPostMapper;

    // 프로젝트 포스트 저장
    public void save(ThesisPostVO thesisPostVO) {
        thesisPostMapper.insert(thesisPostVO);
    }

//    전체 조회
    public List<ThesisPostDTO> findAll(Pagination pagination) {
        return thesisPostMapper.selectAll(pagination);

    }
//    전체 개수
    public int findCount(){
        return thesisPostMapper.selectCount();
    }

}

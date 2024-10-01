package com.app.moa.repository.thesis_post;


import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.Search;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import com.app.moa.mapper.thesis_post.ThesisPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ThesisPostDAO {
    private final ThesisPostMapper thesisPostMapper;

    // 프로젝트 포스트 저장
    public void save(ThesisPostVO thesisPostVO) {
        thesisPostMapper.insert(thesisPostVO);
    }

//    전체 조회
    public List<ThesisPostDTO> findAll(Pagination pagination, Search search) {
        return thesisPostMapper.selectAll(pagination, search);
    }

//    전체 개수
    public int findCount(){
        return thesisPostMapper.selectCount();
    }

//    게시글 ID로 찾기
    public Optional<ThesisPostVO> findById(long id) {return thesisPostMapper.selectById(id);}

//    게시글 수정
    public void update(ThesisPostVO thesisPostVO) {thesisPostMapper.update(thesisPostVO);}

//    게시글 삭제
    public void delete(long id) {thesisPostMapper.delete(id);}
    //    검색 결과 개수 조회
    public int getTotalWithSearch(Search search){
        return thesisPostMapper.selectTotalWithSearch(search);
    }


}

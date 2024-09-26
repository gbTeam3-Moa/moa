package com.app.moa.mapper.thesis_post;


import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThesisPostMapper {
    // 프로젝트 포스트 삽입
    public void insert(ThesisPostVO thesisPostVO);

//    전체 조회
    public List<ThesisPostDTO> selectAll(Pagination pagination);

//    전체 개수
    public int selectCount();
}

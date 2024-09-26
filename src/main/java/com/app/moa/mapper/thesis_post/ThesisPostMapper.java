package com.app.moa.mapper.thesis_post;


import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.thesis_post.ThesisPostDTO;
import com.app.moa.domain.thesis_post.ThesisPostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ThesisPostMapper {
    // 프로젝트 포스트 삽입
    public void insert(ThesisPostVO thesisPostVO);
//    전체 조회
    public List<ThesisPostDTO> selectAll(Pagination pagination);
//    전체 개수
    public int selectCount();
//    게시글 ID로 조회
    public Optional<ThesisPostVO> selectById(Long id);
//    게시글 수정
    public void update(ThesisPostVO thesisPostVO);
//    게시글 삭제
    public void delete(Long id);
//  조회수 증가
    public void increaseViewCountById(Long id);
}

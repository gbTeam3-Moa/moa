package com.app.moa.mapper.post;

import com.app.moa.domain.post.PostDTO;
import com.app.moa.domain.post.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    //    게시글 작성
    public void insert(PostVO postVO);

    // ID로 게시글 조회
   public PostDTO selectById(Long id);

    // ID로 게시글 수정
   public void updateById(PostDTO postDTO);

    // ID로 게시글 삭제
    public void deleteById(Long id);

    // 전체 게시글 조회 (기존 메소드)
    public List<PostDTO> selectAll();
}

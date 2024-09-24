package com.app.moa.mapper.post;

import com.app.moa.domain.post.PostVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    //    게시글 작성
    public void insert(PostVO postVO);
}

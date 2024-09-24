package com.app.moa.mapper.qapost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.qapost.QaPostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QaPostMapper {
    //    게시글 작성
    public void insert(QaPostVO qaPostVO);

    //    게시글 전체 조회
    public List<QaPostDTO> selectAll(@Param("pagination") Pagination pagination, @Param("order") String order);

    //    게시글 전체 개수 조회
    public int selectTotal();
}

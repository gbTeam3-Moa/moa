package com.app.moa.mapper.qapost;

import com.app.moa.domain.qapost.QaPostVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QaPostMapper {
    //    게시글 작성
    public void insert(QaPostVO qaPostVO);

}

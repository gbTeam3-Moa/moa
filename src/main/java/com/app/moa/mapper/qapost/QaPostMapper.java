package com.app.moa.mapper.qapost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.projectpost.ProjectPostVO;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.qapost.QaPostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QaPostMapper {

    public void insert(QaPostVO qaPostVO);


    QaPostDTO selectById(Long id);


    void updateById(QaPostDTO qaPostDTO);


    void deleteById(Long id);
}

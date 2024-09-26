package com.app.moa.mapper.qa_post;

import com.app.moa.domain.qa_post.QaPostDTO;
import com.app.moa.domain.qa_post.QaPostVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QaPostMapper {

    public void insert(QaPostVO qaPostVO);


    QaPostDTO selectById(Long id);


    void updateById(QaPostDTO qaPostDTO);


    void deleteById(Long id);
}

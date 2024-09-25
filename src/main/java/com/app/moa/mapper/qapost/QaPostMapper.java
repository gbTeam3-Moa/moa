package com.app.moa.mapper.qapost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.post.PostVO;
import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.projectpost.ProjectPostVO;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.qapost.QaPostVO;
import com.app.moa.domain.thesispost.ThesisPostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QaPostMapper {

    public void insert(QaPostVO qaPostVO);


    //    전체 조회
    public List<QaPostDTO> selectAll(Pagination pagination);

    //    전체 개수
    public int selectCount();


    void updateById(QaPostDTO qaPostDTO);


    void deleteById(Long id);
}

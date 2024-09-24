package com.app.moa.mapper.qapost;

import com.app.moa.domain.post.Pagination;
import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.projectpost.ProjectPostVO;
import com.app.moa.domain.qapost.QaPostDTO;
import com.app.moa.domain.qapost.QaPostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QaPostMapper {
    // 프로젝트 포스트 삽입
    void insert(Long id);

    // ID로 프로젝트 포스트 조회
    QaPostDTO selectById(Long id);

    // ID로 프로젝트 포스트 수정
    void updateById(QaPostDTO qaPostDTO);

    // ID로 프로젝트 포스트 삭제
    void deleteById(Long id);
}

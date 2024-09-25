package com.app.moa.mapper.projectpost;

import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.projectpost.ProjectPostVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectPostMapper {
    // 프로젝트 포스트 삽입
    public void insert(ProjectPostVO projectPostVO);

    // ID로 프로젝트 포스트 조회
    public ProjectPostDTO selectById(Long id);

    // ID로 프로젝트 포스트 수정
    public void updateById(ProjectPostDTO projectPostDTO);

    // ID로 프로젝트 포스트 삭제
    public void deleteById(Long id);
}
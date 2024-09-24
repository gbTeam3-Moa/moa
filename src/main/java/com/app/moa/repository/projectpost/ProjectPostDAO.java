package com.app.moa.repository.projectpost;


import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.projectpost.ProjectPostVO;
import com.app.moa.mapper.projectpost.ProjectPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProjectPostDAO {
    private final ProjectPostMapper projectPostMapper;

    // 프로젝트 포스트 저장
    public void save(ProjectPostVO projectPostVO) {
        projectPostMapper.insert(projectPostVO);
    }

    // ID로 프로젝트 포스트 조회
    public ProjectPostDTO findById(Long id) {
        return projectPostMapper.selectById(id);
    }

    // ID로 프로젝트 포스트 수정
    public void update(ProjectPostDTO projectPostDTO) {
        projectPostMapper.updateById(projectPostDTO);
    }

    // ID로 프로젝트 포스트 삭제
    public void delete(Long id) {
        projectPostMapper.deleteById(id);
    }
}
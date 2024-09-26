package com.app.moa.service.project_post;


import com.app.moa.domain.project_post.ProjectPostDTO;
import com.app.moa.domain.project_post.ProjectPostVO;
import com.app.moa.repository.project_post.ProjectPostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectPostServiceImpl implements ProjectPostService {

    private final ProjectPostDAO projectPostDAO;

    @Override
    public void write(ProjectPostVO projectPostVO) {
        projectPostDAO.save(projectPostVO);
    }

    @Override
    public ProjectPostDTO findById(Long id) {
        return projectPostDAO.findById(id);
    }

    @Override
    public void updatePost(ProjectPostDTO projectPostDTO) {
        projectPostDAO.update(projectPostDTO);
    }

    @Override
    public void deletePost(Long id) {
        projectPostDAO.delete(id);
    }
}

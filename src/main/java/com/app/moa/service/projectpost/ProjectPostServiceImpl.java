package com.app.moa.service.projectpost;


import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.projectpost.ProjectPostVO;
import com.app.moa.repository.projectpost.ProjectPostDAO;
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

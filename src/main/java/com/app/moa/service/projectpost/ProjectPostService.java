package com.app.moa.service.projectpost;

import com.app.moa.domain.projectpost.ProjectPostDTO;
import com.app.moa.domain.projectpost.ProjectPostVO;

public interface ProjectPostService {

    public void write(ProjectPostVO projectPostVO);
    public ProjectPostDTO findById(Long id);
    public void updatePost(ProjectPostDTO projectPostDTO);
    public void deletePost(Long id);

}


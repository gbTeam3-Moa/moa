package com.app.moa.service.project_post;

import com.app.moa.domain.project_post.ProjectPostDTO;
import com.app.moa.domain.project_post.ProjectPostVO;

public interface ProjectPostService {

    public void write(ProjectPostVO projectPostVO);
    public ProjectPostDTO findById(Long id);
    public void updatePost(ProjectPostDTO projectPostDTO);
    public void deletePost(Long id);

}


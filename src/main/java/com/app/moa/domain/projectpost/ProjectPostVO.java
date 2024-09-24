package com.app.moa.domain.projectpost;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPostVO {
    private Long id;
    private String projectField;
    private String projectRequirement;

    public ProjectPostDTO toDTO() {
        ProjectPostDTO projectPostDTO = new ProjectPostDTO();
        projectPostDTO.setId(id);
        projectPostDTO.setProjectField(projectField);
        projectPostDTO.setProjectRequirement(projectRequirement);
        return projectPostDTO;
    }
}
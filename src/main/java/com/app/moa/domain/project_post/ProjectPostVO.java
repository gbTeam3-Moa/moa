package com.app.moa.domain.project_post;

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
    private String studentMajor;
    private String projectField;
    private String projectProfit;
    private String projectPeriod;
    private String projectDeadline;
    private String projectStartDate;
    private String projectSchedule;
    private String projectRequirement;

    public ProjectPostDTO toDTO() {
       ProjectPostDTO projectPostDTO = new ProjectPostDTO();
       projectPostDTO.setId(id);
       projectPostDTO.setStudentMajor(studentMajor);
       projectPostDTO.setProjectField(projectField);
       projectPostDTO.setProjectProfit(projectProfit);
       projectPostDTO.setProjectPeriod(projectPeriod);
       projectPostDTO.setProjectDeadline(projectDeadline);
       projectPostDTO.setProjectStartDate(projectStartDate);
       projectPostDTO.setProjectSchedule(projectSchedule);
       projectPostDTO.setProjectRequirement(projectRequirement);
       return projectPostDTO;
    }
}
package com.app.moa.domain.projectpost;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPostDTO {
    private Long id;
    private String projectField;
    private String projectRequirement;

    public ProjectPostVO toVO() {
        return new ProjectPostVO(id,projectField,projectRequirement);
    }
}

package com.app.moa.domain.thesispost;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ThesisPostDTO {
    private Long id;
    private String researchField;
    private String researchRequirement;

    public ThesisPostVO toVO(){

    }

}

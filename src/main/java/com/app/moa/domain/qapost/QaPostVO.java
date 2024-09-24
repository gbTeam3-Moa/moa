package com.app.moa.domain.qapost;

import com.app.moa.domain.projectpost.ProjectPostDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class QaPostVO implements Serializable {
    private Long id;
    private Long PostId;

    public QaPostDTO toDTO() {
        QaPostDTO qaPostDTO = new QaPostDTO();
        qaPostDTO.setId(id);
        return qaPostDTO;
    }
}

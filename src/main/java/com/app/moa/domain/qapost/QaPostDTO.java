package com.app.moa.domain.qapost;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class QaPostDTO {
    private Long id;
    private Long postId;

    public QaPostVO toVO(){
        return new QaPostVO(id, postId);
    }
}

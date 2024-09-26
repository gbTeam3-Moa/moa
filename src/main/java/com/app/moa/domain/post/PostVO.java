package com.app.moa.domain.post;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private int postType;
    private Long memberId;
    private int postView;
    private String createdDate;
    private String updatedDate;

}

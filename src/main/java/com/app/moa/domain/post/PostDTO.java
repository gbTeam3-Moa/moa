package com.app.moa.domain.post;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String postTitle;
    private String postContent;
    private int postType;
    private Long userId;
    private int postView;
    private String createdDate;
    private String updatedDate;

    public PostVO toVO()
    {return new PostVO(id,postTitle,postContent,postType,userId,postView,createdDate,updatedDate);}
}

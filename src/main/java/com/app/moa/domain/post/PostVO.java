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
    private Long userId;
    private int postView;
    private String createdDate;
    private String updatedDate;

    public PostDTO toDTO(){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(id);
        postDTO.setPostTitle(postTitle);
        postDTO.setPostContent(postContent);
        postDTO.setPostType(postType);
        postDTO.setUserId(userId);
        postDTO.setPostView(postView);
        postDTO.setCreatedDate(createdDate);
        postDTO.setUpdatedDate(updatedDate);
        return postDTO;
    }
}

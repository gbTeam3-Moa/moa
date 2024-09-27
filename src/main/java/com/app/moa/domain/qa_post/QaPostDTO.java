package com.app.moa.domain.qa_post;


import com.app.moa.domain.post.PostVO;
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
    private String postTitle;
    private String postContent;
    private int postType;
    private Long memberId;
    private int postView;
    private String memberMajor;
    private String createdDate;
    private String updatedDate;


    public PostVO toPostVO(){
        return new PostVO(id, postTitle, postContent, postType, memberId, postView, createdDate, updatedDate);
    }

    public QaPostVO toVO() {
        return new QaPostVO(id);
    }
}

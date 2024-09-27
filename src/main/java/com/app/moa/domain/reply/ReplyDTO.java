
package com.app.moa.domain.reply;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long id;
    private Long postId;
    private Long memberId;
    private String replyContent;
    private String createdDate;
    private String updatedDate;
    private Long groupId;
    private String replyDepth;

    public ReplyVO toVO(){return new ReplyVO(id, postId, memberId, replyContent, createdDate, updatedDate, groupId, replyDepth);}
}

package com.app.moa.domain.reply;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
    private Long id;
    private Long postId;
    private Long memberId;
    private String replyContent;
    private String createdDate;
    private String updatedDate;
    private Long groupId;
    private int replyDepth;
}

package com.app.moa.domain.reply;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReplyVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long postId;
    private Long memberId;
    private String replyContent;
    private String createdDate;
    private String updatedDate;
    private Long groupId;
    private Long replyDepth;
}

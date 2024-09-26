package com.app.moa.domain.report;

//import com.app.moa.domain.post.PostVO;
//import com.app.moa.domain.user.UserVO;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
    private Long id;
    private Long postId;
    private Long memberId;
    private String reportReason;
    private Long reportStatus;
    private String postTitle;
    private int postView;
    private String createdDate;
    private int replyCount;
    private String memberNickname;

    public ReportVO toVO(){return new ReportVO(id, postId, memberId, reportReason, reportStatus);}
//    public ReportVO toReportVO(){return new ReportVO(id, userId, postId, createdDate, postTitle,postView, reportReason, reportStatus);}
}
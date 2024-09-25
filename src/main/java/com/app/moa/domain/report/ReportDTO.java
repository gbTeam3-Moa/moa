package com.app.moa.domain.report;


import com.app.moa.domain.post.PostVO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class ReportDTO {
    private Long id;
    private Long postId;
    private Long userId;
    private String reportReason;
    private Long reportStatus;

    public ReportVO toVO(){
        return new ReportVO(id, postId, userId, reportReason, reportStatus);
    }
}
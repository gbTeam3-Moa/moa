package com.app.moa.domain.report;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ReportVO {
    private Long id;
    private Long postId;
    private Long userId;
    private String reportReason;
    private Long reportStatus;

}

package com.app.moa.domain.thesis_post;


import com.app.moa.domain.post.PostVO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ThesisPostDTO {
    private Long id;
    private String professorMajor; //학교 및 전공
    private String researchField; // 프로젝트 분야
    private String researchProfit; //예상 금액
    private String researchPeriod; //예상 기간
    private String researchDeadline; //모집 마감일
    private String researchStartDate; //예상 시작일
    private String researchSchedule; // 논문 예정 사항
    private String researchRequirement; //모집 요건

    private String postTitle;
    private String postContent;
    private int postType;
    private Long memberId;
    private int postView;
    private String createdDate;
    private String updatedDate;

   public ThesisPostVO toVO(){return new ThesisPostVO(id,professorMajor,researchField,researchProfit,researchPeriod,researchDeadline,researchStartDate,researchSchedule,researchRequirement);}
    public PostVO toPostVO(){return new PostVO(id,postTitle,postContent,postType,memberId,postView,createdDate,updatedDate);}
}



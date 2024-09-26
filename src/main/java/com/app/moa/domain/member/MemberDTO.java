package com.app.moa.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberNickName;
    private String memberEmail;
    private String memberPassword;
    private int memberType;
    private String memberName;
    private Integer memberGender;
    private String memberBirthday;
    private String memberArea;
    private String memberDetailedArea;
    private String memberAddress;
    private String memberIntroduction;
    private String memberHomepageAddress;
    private String memberCellPhone;
    private String memberPhone;
    private String memberFax;
    private String memberMajor;
    private String createdDate;
    private String updatedDate;

    public MemberVO toVO(){
        return new MemberVO(id, memberNickName, memberEmail, memberPassword, memberType, memberName, memberGender, memberBirthday, memberArea,
                memberDetailedArea, memberAddress, memberIntroduction, memberHomepageAddress, memberCellPhone, memberPhone, memberFax, memberMajor, createdDate, updatedDate);
    }
}

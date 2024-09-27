package com.app.moa.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberNickname;
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

    public MemberDTO toDTO(){
        return new MemberDTO(id, memberNickname, memberEmail, memberPassword, memberType, memberName, memberGender, memberBirthday, memberArea,
                memberDetailedArea, memberAddress, memberIntroduction, memberHomepageAddress, memberCellPhone, memberPhone, memberFax, memberMajor, createdDate, updatedDate);
    }

}

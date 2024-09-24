package com.app.moa.domain.user;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String userId;
    private String userEmail;
    private String userPassword;
    private int userType;
    private String userName;
    private int userGender;
    private String userBirthday;
    private String userArea;
    private String userDetailedArea;
    private String userAddress;
    private String userIntroduction;
    private String userHomepageAddress;
    private String userCellPhone;
    private String userPhone;
    private String userFax;
    private String userMajor;
    private String createdDate;
    private String updatedDate;

    public UserVO toVO(){
        return new UserVO(id, userId, userEmail, userPassword, userType, userName, userGender, userBirthday, userArea,
                userDetailedArea, userAddress, userIntroduction, userHomepageAddress, userCellPhone, userPhone, userFax, userMajor, createdDate, updatedDate);
    }
}

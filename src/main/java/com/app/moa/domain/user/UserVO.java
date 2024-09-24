package com.app.moa.domain.user;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String userId;
    private String userEmail;
    private String userPassword;
    private int userType;
    private String userName;
    private Integer userGender;
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

    public UserDTO toDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setUserEmail(userEmail);
        userDTO.setUserPassword(userPassword);
        userDTO.setUserType(userType);
        userDTO.setUserName(userName);
        userDTO.setUserGender(userGender);
        userDTO.setUserBirthday(userBirthday);
        userDTO.setUserArea(userArea);
        userDTO.setUserDetailedArea(userDetailedArea);
        userDTO.setUserAddress(userAddress);
        userDTO.setUserIntroduction(userIntroduction);
        userDTO.setUserHomepageAddress(userHomepageAddress);
        userDTO.setUserCellPhone(userCellPhone);
        userDTO.setUserPhone(userPhone);
        userDTO.setUserFax(userFax);
        userDTO.setUserMajor(userMajor);
        userDTO.setCreatedDate(createdDate);
        userDTO.setUpdatedDate(updatedDate);
        return userDTO;
    }

}

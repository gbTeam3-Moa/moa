package com.app.moa.mapper;

import com.app.moa.domain.user.UserDTO;
import com.app.moa.domain.user.UserVO;
import com.app.moa.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail("hds@gmail.com");
        userDTO.setUserPassword("123456");
        userDTO.setUserId("hdsTest1");
        userDTO.setUserType(0);

        userMapper.insert(userDTO.toVO());
    }

    @Test
    public void testSelectByUserEmailAndUserPassword(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId("sm@gmail.com");
        userDTO.setUserEmail("sm@gmail.com");
        userDTO.setUserPassword("12345");

        Optional<UserVO> foundUser =
                userMapper.selectByUserEmailAndUserPassword(userDTO.toVO());
        foundUser.map(UserVO::toString).ifPresent(log::info);
    }

    @Test
    public void testSelectById() {
        Long id = 1L;

        Optional<UserVO> foundUser = userMapper.selectById(id);
        foundUser.map(UserVO::toString).ifPresent(log::info);
    }

    @Test
    public void testSelectByUserEmail() {
        String userEmail = "sm@gmail.com";

        Optional<UserVO> foundUser = userMapper.selectByUserEmail(userEmail);
        foundUser.map(UserVO::toString).ifPresent(log::info);
    }



    @Test
    public void testDelete() {
        Long id = 22L;
        userMapper.delete(id);
    }
}
















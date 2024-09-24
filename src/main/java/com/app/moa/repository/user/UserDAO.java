package com.app.moa.repository.user;

import com.app.moa.domain.user.UserVO;
import com.app.moa.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    //    회원가입
    public void save(UserVO userVO){
        userMapper.insert(userVO);
    }

    //    로그인
    public Optional<UserVO> findByUserEmailAndUserPassword(UserVO userVO){
        return userMapper.selectByUserEmailAndUserPassword(userVO);
    }

    //    회원 정보 조회
    public Optional<UserVO> findById(Long id){
        return userMapper.selectById(id);
    }

    //    회원 정보 수정
    public void setUser(UserVO userVO){
        userMapper.update(userVO);
    }

    //    회원 정보 삭제
    public void delete(Long id) { userMapper.delete(id); }
}

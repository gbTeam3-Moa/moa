package com.app.moa.mapper.user;

import com.app.moa.domain.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    //    회원가입
    public void insert(UserVO userVO);
    //    로그인
    public Optional<UserVO> selectByUserEmailAndUserPassword(UserVO userVO);

    //    id로 회원 정보 조회
    public Optional<UserVO> selectById(Long id);

    //    Email로 회원 정보 조회
    public Optional<UserVO> selectByUserEmail(String userEmail);

    //    회원 정보 수정
    public void update(UserVO userVO);

    //    회원 정보 삭제
    public void delete(Long id);
}

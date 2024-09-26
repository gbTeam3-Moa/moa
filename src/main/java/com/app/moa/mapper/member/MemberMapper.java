package com.app.moa.mapper.member;

import com.app.moa.domain.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    //    회원가입
    public void insert(MemberVO memberVO);
    //    로그인
    public Optional<MemberVO> selectByMemberEmailAndMemberPassword(MemberVO memberVO);

    //    id로 회원 정보 조회
    public Optional<MemberVO> selectById(Long id);

    //    Email로 회원 정보 조회
    public Optional<MemberVO> selectByMemberEmail(String memberEmail);

    //    회원 정보 수정
    public void update(MemberVO memberVO);

    //    회원 정보 삭제
    public void delete(Long id);
}

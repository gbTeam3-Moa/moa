package com.app.moa.controller.member;

import com.app.moa.domain.member.MemberDTO;
import com.app.moa.domain.member.MemberVO;
import com.app.moa.exception.LoginFailException;
import com.app.moa.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;
import java.util.Optional;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("join")
    public void goToJoinForm(MemberDTO memberDTO){;}

    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO){
        log.info("{}", memberDTO);
        memberService.join(memberDTO.toVO());
        return new RedirectView( "/member/login");
    }

    @GetMapping("login")
    public void goToLoginForm(MemberDTO memberDTO){;}

    @PostMapping("login")
    public RedirectView login(MemberDTO memberDTO, boolean save, HttpSession session){

        if(save){
//          쿠키 생성, 저장
            Cookie saveCookie = new Cookie("saveCookie", memberDTO.toString());
        } else{
//          쿠키 삭제
        }

//        1. 안에서 할 게 많아서 람다로 쓰기에 제약이 있을 때 .isPresent() 사용
//        if(memberService.login(memberDTO.toVO()).isPresent()){
//
//        }

        Optional<MemberVO> foundMember = memberService.login(memberDTO.toVO());
//        2. null일 때는 아무것도 하지 않고, null이 아닐 때만 무언가를 할 때 .ifPresent(람다식) 사용
//        foundMember.ifPresent((member) -> {
//            session.setAttribute("memberId", memberDTO.getId());
//        });

//        3. null일 때와 null이 아닐 때 모두 할 게 있을 때 .orElseThrow(람다식) 사용
        MemberVO memberVO = foundMember.orElseThrow(() -> {throw new LoginFailException("(" + LocalTime.now() +")로그인 실패");});
//        session.setAttribute("memberId", memberVO.getId());
        session.setAttribute("member", memberVO);
        memberDTO.setMemberEmail(memberDTO.getMemberNickname());
        log.info("{}", memberDTO);
        memberService.login(memberDTO.toVO())
                .ifPresentOrElse(
                        (member) -> {
                            log.info(member.toString());
                            log.info("로그인 성공");
                        },
                        () -> {
                            log.info("로그인 실패");
                        });

        return new RedirectView( "/templates/main/main-login/main-login.html");
    }

    //    로그 아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session) {
        session.invalidate();
        return new RedirectView("/member/login");
    }

    //    회원 정보 조회 및 수정
    @GetMapping(value = {"read", "update"})
    public void goToReadForm(Long id, Model model){
        model.addAttribute("memberDTO", memberService.getMember(id).get().toDTO());
    }

    @PostMapping("update")
    public RedirectView update(MemberDTO memberDTO){
        log.info(memberDTO.toString());
        memberService.update(memberDTO.toVO());
        return new RedirectView("/member/read?id=" + memberDTO.getId());
    }

    //    회원 탈퇴
    @GetMapping("delete")
    public RedirectView delete(Long id){
        memberService.delete(id);
        return new RedirectView("/member/login");
    }

}

package com.app.moa.controller.member;

import com.app.moa.domain.member.MemberDTO;
import com.app.moa.domain.member.MemberVO;
import com.app.moa.exception.LoginFailException;
import com.app.moa.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void goToLoginForm(@RequestParam(required = false) Boolean status, MemberDTO memberDTO, HttpServletRequest request, Model model){

        Cookie[] cookies = request.getCookies();

        for(int i = 0; i < cookies.length; i++){
            log.info(cookies[i].getName());

            if(cookies[i].getName().equals("save")){
                model.addAttribute("save", cookies[i].getValue());
            }
            if(cookies[i].getName().equals("memberEmail")){
                memberDTO.setMemberEmail(cookies[i].getValue());
            }

        }
    }

    @PostMapping("login")
    public RedirectView login(MemberDTO memberDTO, String save, HttpSession session, HttpServletResponse response){

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

        Optional<MemberVO> foundMember = memberService.login(memberDTO.toVO());

        MemberVO memberVO = foundMember.orElseThrow(() -> {throw new LoginFailException("(" + LocalTime.now() +")로그인 실패");});
        session.setAttribute("member", memberVO);
        log.info("{}", memberVO);

        if(save != null){
//            쿠키 생성, 저장
            Cookie saveCookie = new Cookie("save", save);
            Cookie memberEmailCookie = new Cookie("memberEmail", memberDTO.getMemberEmail());

//            -1: 쿠키 계속 유지
            saveCookie.setMaxAge(-1);
            memberEmailCookie.setMaxAge(-1);

            response.addCookie(saveCookie);
            response.addCookie(memberEmailCookie);

        }else{
//            쿠키 삭제
            Cookie saveCookie = new Cookie("save", null);
            Cookie memberEmailCookie = new Cookie("memberEmail", null);

            saveCookie.setMaxAge(0);
            memberEmailCookie.setMaxAge(0);

            response.addCookie(saveCookie);
            response.addCookie(memberEmailCookie);
        }

        return new RedirectView( "/main-login-page");
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

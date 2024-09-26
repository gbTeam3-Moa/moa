package com.app.moa.controller.member;

import com.app.moa.domain.member.MemberDTO;
import com.app.moa.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView login(MemberDTO memberDTO){
        memberDTO.setMemberEmail(memberDTO.getMemberNickName());
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

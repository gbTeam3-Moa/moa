package com.app.moa.controller.user;

import com.app.moa.domain.user.UserDTO;
import com.app.moa.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/join/*")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("join")
    public void goToJoinForm(UserDTO userDTO){;}

    @PostMapping("join")
    public RedirectView join(UserDTO userDTO){
        log.info("{}", userDTO);
        userService.join(userDTO.toVO());
        return new RedirectView( "/login/login");
    }

    @GetMapping("login")
    public void goToLoginForm(UserDTO userDTO){;}

    @PostMapping("login")
    public RedirectView login(UserDTO userDTO){
        userService.login(userDTO.toVO())
                .ifPresentOrElse(
                        (user) -> {
                            log.info(user.toString());
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
        model.addAttribute("memberDTO", userService.getUser(id).get().toDTO());
    }

    @PostMapping("update")
    public RedirectView update(UserDTO userDTO){
        log.info(userDTO.toString());
        userService.update(userDTO.toVO());
        return new RedirectView("/user/read?id=" + userDTO.getId());
    }

    //    회원 탈퇴
    @GetMapping("delete")
    public RedirectView delete(Long id){
        userService.delete(id);
        return new RedirectView("/user/login");
    }

}

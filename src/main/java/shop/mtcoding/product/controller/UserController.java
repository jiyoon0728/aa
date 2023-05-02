package shop.mtcoding.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.product.dto.user.JoinReqDto;
import shop.mtcoding.product.dto.user.LoginReqDto;
import shop.mtcoding.product.handler.ex.CustomException;
import shop.mtcoding.product.model.user.User;
import shop.mtcoding.product.model.user.UserRepository;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(LoginReqDto loginReqDto) {
        if (loginReqDto.getUsername() == null || loginReqDto.getUsername().isEmpty()) {
            throw new CustomException("username을 작성해주세요");
        }
        if (loginReqDto.getPassword() == null || loginReqDto.getPassword().isEmpty()) {
            throw new CustomException("password를 작성해주세요");
        }
        User principal = userRepository.login(loginReqDto);

        session.setAttribute("principal", principal);
        if (principal != null) {
            return "redirect:/";
        } else {
            return "redirect:/loginForm";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) {

        // 유효성 체크
        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            throw new CustomException("username을 작성해주세요");
            // return new ResponseDto<>(-1, "username이 입력되지 않았습니다.", null);
        }
        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            throw new CustomException("password를 작성해주세요");
            // return new ResponseDto<>(-1, "password가 입력되지 않았습니다.", null);
        }

        if (joinReqDto.getEmail() == null || joinReqDto.getEmail().isEmpty()) {
            throw new CustomException("email을 작성해주세요");
            // return new ResponseDto<>(-1, "email이 입력되지 않았습니다.", null);
        }

        // 유저 정보 인서트
        userRepository.insert(joinReqDto);

        return "redirect:/loginForm";
    }
}

package shop.mtcoding.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.product.dto.User.LoginReqDto;
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
        User principal = userRepository.login(loginReqDto);

        session.setAttribute("principal", principal);
        if (principal!=null) {
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

}
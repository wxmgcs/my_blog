package cn.diyai.my_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器.
 * 
 */
@Controller
public class MainController {
	@GetMapping("/")
	public String root() {
		return "redirect:/blogs/list";
	}
	
	@GetMapping("/index")
	public String index() {
		return "redirect:/blogs/list";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，用户名或者密码错误！");
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
}

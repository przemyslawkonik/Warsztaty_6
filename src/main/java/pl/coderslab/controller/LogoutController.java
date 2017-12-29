package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.bean.SessionManager;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@GetMapping("")
	public String logout() {
		SessionManager.session().invalidate();
		return "redirect:/";
	}
}

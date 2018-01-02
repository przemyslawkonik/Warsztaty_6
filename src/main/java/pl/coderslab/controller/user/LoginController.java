package pl.coderslab.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.bean.LoginData;
import pl.coderslab.bean.SessionManager;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
	private UserRepository userRep;

	@Autowired
	public LoginController(UserRepository userRep) {
		this.userRep = userRep;
	}

	@GetMapping("")
	public String login(Model m) {
		m.addAttribute("loginData", new LoginData());
		return "user/login";
	}

	@PostMapping("")
	public String login(@ModelAttribute LoginData ld, Model m) {
		User u = userRep.findOneByEmail(ld.getEmail());
		if (u != null && u.isPasswordCorrect(ld.getPassword())) {
			SessionManager.session().setAttribute("user", u);
			return "redirect:/";
		}
		m.addAttribute("errorMsg", "Incorrect data");
		return "user/login";
	}

}

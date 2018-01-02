package pl.coderslab.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.bean.SessionManager;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private UserRepository userRep;

	@Autowired
	public RegisterController(UserRepository userRep) {
		this.userRep = userRep;
	}

	@GetMapping("")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "user/register";
	}

	@PostMapping("")
	public String register(@Valid @ModelAttribute User u, BindingResult br) {
		if (br.hasErrors()) {
			return "user/register";
		}
		userRep.save(u);
		SessionManager.session().setAttribute("user", u);
		return "redirect:/";
	}
}

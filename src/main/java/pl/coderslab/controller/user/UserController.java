package pl.coderslab.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	private UserRepository userRep;
	private TweetRepository tweetRep;

	public UserController(UserRepository userRep, TweetRepository tweetRep) {
		this.userRep = userRep;
		this.tweetRep = tweetRep;
	}

	@GetMapping("/{id}")
	public String userDetails(@PathVariable long id, Model m) {
		m.addAttribute("user", userRep.findOne(id));
		m.addAttribute("tweets", tweetRep.findByUserId(id));
		return "user/user";
	}

}

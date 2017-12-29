package pl.coderslab.controller;

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
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;

@Controller
@RequestMapping("")
public class HomeController {
	private TweetRepository tweetRep;

	@Autowired
	public HomeController(TweetRepository tweetRep) {
		this.tweetRep = tweetRep;
	}

	@GetMapping("")
	public String home(Model m) {
		m.addAttribute("tweets", tweetRep.findAllByOrderByCreatedDesc());
		m.addAttribute("tweet", new Tweet());
		return "home";
	}

	@PostMapping("")
	public String addTweet(@Valid @ModelAttribute Tweet t, BindingResult br) {
		if (br.hasErrors()) {
			return "home";
		}
		t.setUser((User) SessionManager.session().getAttribute("user"));
		tweetRep.save(t);
		return "redirect:/";
	}
}

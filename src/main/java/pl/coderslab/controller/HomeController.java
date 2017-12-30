package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
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
		m.addAttribute("comment", new Comment());
		return "home";
	}

}

package pl.coderslab.controller.post;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;

@Controller
@RequestMapping("/tweets")
public class TweetController {
	private TweetRepository tweetRep;

	@Autowired
	public TweetController(TweetRepository tweetRep) {
		this.tweetRep = tweetRep;
	}

	@PostMapping("/add")
	public String add(@Valid @ModelAttribute Tweet tweet, BindingResult br) {
		if (br.hasErrors()) {
			return "home";
		}
		tweetRep.save(tweet);
		return "redirect:/";
	}
}

package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Comment;
import pl.coderslab.repository.CommentRepository;

@Controller
@RequestMapping("/comments")
public class CommentController {
	private CommentRepository commentRep;

	@Autowired
	public CommentController(CommentRepository commentRep) {
		this.commentRep = commentRep;
	}

	@PostMapping("/add")
	public String add(@Valid @ModelAttribute Comment comment, BindingResult br) {
		if (br.hasErrors()) {
			return "home";
		}
		commentRep.save(comment);
		return "redirect:/";
	}
}

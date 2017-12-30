package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.repository.MessageRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {
	private MessageRepository messageRep;

	public MessageController(MessageRepository messageRep) {
		this.messageRep = messageRep;
	}

	@GetMapping("/{id}")
	public String userMessagesMenu(Model m, @PathVariable long id) {
		m.addAttribute("id", id);
		return "message_menu";
	}

	@GetMapping("received/{id}")
	public String userMessagesReceived(Model m, @PathVariable long id) {
		m.addAttribute("messages", messageRep.findByReceiverId(id));
		return "message_list";
	}

	@GetMapping("send/{id}")
	public String userMessagesSend(Model m, @PathVariable long id) {
		m.addAttribute("messages", messageRep.findBySenderId(id));
		return "message_list";
	}

}

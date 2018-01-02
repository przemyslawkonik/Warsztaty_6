package pl.coderslab.controller.post;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Message;
import pl.coderslab.repository.MessageRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {
	private MessageRepository messageRep;
	private UserRepository userRep;

	@Autowired
	public MessageController(MessageRepository messageRep, UserRepository userRep) {
		this.messageRep = messageRep;
		this.userRep = userRep;
	}

	@GetMapping("/{id}")
	public String userMessagesMenu(Model m, @PathVariable long id) {
		m.addAttribute("id", id);
		m.addAttribute("messages", messageRep.findByUserId(id));
		return "message/message_menu";
	}

	@GetMapping("/received/{id}")
	public String userMessagesReceived(Model m, @PathVariable long id) {
		m.addAttribute("messages", messageRep.findByReceiverIdOrderByCreatedDesc(id));
		return "message/message_menu";
	}

	@GetMapping("/sended/{id}")
	public String userMessagesSended(Model m, @PathVariable long id) {
		m.addAttribute("messages", messageRep.findBySenderIdOrderByCreatedDesc(id));
		return "message/message_menu";
	}

	@GetMapping("/send/{id}")
	public String sendMessage(Model m, @PathVariable long id) {
		m.addAttribute("message", new Message());
		m.addAttribute("receiver", userRep.findOne(id));
		return "message/send_message";
	}

	@PostMapping("/send")
	public String sendMessage(@Valid @ModelAttribute Message message, BindingResult br) {
		if (br.hasErrors()) {
			return "message/send_message";
		}
		messageRep.save(message);
		return "redirect:/users/" + message.getSender().getId();
	}

}

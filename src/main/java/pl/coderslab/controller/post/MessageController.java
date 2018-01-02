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

@Controller
@RequestMapping("/messages")
public class MessageController {
	private MessageRepository messageRep;

	@Autowired
	public MessageController(MessageRepository messageRep) {
		this.messageRep = messageRep;
	}

	@GetMapping("/{id}")
	public String userMessagesMenu(Model m, @PathVariable long id) {
		m.addAttribute("id", id);
		return "message_menu";
	}

	@GetMapping("/received/{id}")
	public String userMessagesReceived(Model m, @PathVariable long id) {
		m.addAttribute("messages", messageRep.findByReceiverId(id));
		return "message_list";
	}

	@GetMapping("/sended/{id}")
	public String userMessagesSended(Model m, @PathVariable long id) {
		m.addAttribute("messages", messageRep.findBySenderId(id));
		return "message_list";
	}

	@GetMapping("/send/{id}")
	public String sendMessage(Model m, @PathVariable long id) {
		m.addAttribute("message", new Message());
		m.addAttribute("reciverId", id);
		return "send_message";
	}

	@PostMapping("/send")
	public String sendMessage(@Valid @ModelAttribute Message message, BindingResult br) {
		if (br.hasErrors()) {
			return "add_message";
		}
		messageRep.save(message);
		return "redirect:/users/" + message.getSender().getId();
	}

}

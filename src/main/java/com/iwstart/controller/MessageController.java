package com.iwstart.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iwstart.model.Mensagem;
import com.iwstart.model.User;
import com.iwstart.repository.MessageRepository;
import com.iwstart.repository.UserRepository;

@Controller
@RequestMapping("/msg")
public class MessageController {

	@Autowired
	private MessageRepository msgRepo;
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping(path = "/nova")
	public String nova(Model model) {
		Mensagem msg = new Mensagem();
		model.addAttribute("msg", msg);
		
		//findAll(new Sort(Direction.ASC, "name"))
		List<User> users = userRepo.findAll();//ordernar nome depois para listar na pagina
		model.addAttribute("users", users);
		
		return "pagina-criar";
	}

	@PostMapping(path = "/criar")
	public String criar(Mensagem msg) {
		if (!msg.getTexto().isEmpty()) {
			msg.setDataHora(LocalDateTime.now());
			msgRepo.save(msg);
		}
		return "";
	}
}

package hu.autsoft.hwsw.spring.web.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
}

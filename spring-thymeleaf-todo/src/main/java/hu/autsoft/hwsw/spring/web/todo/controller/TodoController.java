package hu.autsoft.hwsw.spring.web.todo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.autsoft.hwsw.spring.web.todo.model.Todo;

@Controller
public class TodoController {
	
	List<Todo> todos = new ArrayList<>();

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("todos", todos);
		model.put("newTodo", new Todo());
		return "index";
	}
	
	@PostMapping("/todo")
	public String home(Todo todo) {
		todos.add(todo);
		return "redirect:/";
	}
	
}

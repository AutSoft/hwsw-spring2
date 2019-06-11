package hu.autsoft.hwsw.spring.web.todo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TodoController.class)
public class TodoControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void testIndexCanBeRendered() throws Exception {
        mockMvc.perform(get("/"))
        	.andExpect(status().isOk())
        	.andExpect(view().name("index"))
        	.andExpect(model().attributeExists("newTodo", "todos"))
        	.andExpect(content().string(containsString("Welcome to the TODO application")));
    }
	
	@Test
    public void testTodoCanBeAddedViaForm() throws Exception {
        mockMvc.perform(post("/todo").param("description", "sampledesc").param("assignee", "gabor"))
        	.andExpect(status().isFound())
        	.andExpect(view().name("redirect:/"));
        
        mockMvc.perform(get("/"))
    	.andExpect(status().isOk())
    	.andExpect(view().name("index"))
    	.andExpect(model().attributeExists("newTodo", "todos"))
    	.andExpect(content().string(both(containsString("gabor")).and(containsString("sampledesc"))));
    }

}

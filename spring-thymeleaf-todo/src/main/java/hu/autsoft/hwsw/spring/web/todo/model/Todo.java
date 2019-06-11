package hu.autsoft.hwsw.spring.web.todo.model;

public class Todo {

	private String description;
	
	private String assignee;
	
	public Todo() {
	}
	
	public Todo(String description, String assignee) {
		super();
		this.description = description;
		this.assignee = assignee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	
	
}

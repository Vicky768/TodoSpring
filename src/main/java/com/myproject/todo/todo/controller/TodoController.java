package com.myproject.todo.todo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myproject.todo.todo.model.Todo;
import com.myproject.todo.todo.service.TodoService;
/*
 * This is the controller class of Todo 
 * 
 * Control the api endpoints 
 * 
 */
@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	/*
	 * @param Todo
	 * @return get all the todos
	 */
	
	@GetMapping("/todo/getAllTodos")
	public List<Todo> getAllTodos(){
		return todoService.showAllTasks();
	}
	/*
	 * @param Todo id
	 * @return get todo with the id 
	 */
	
	@GetMapping("/todo/getATodo/{id}")
	public Todo getTodoById(@PathVariable Integer id) {
		return todoService.showATodo(id);
	}
	/*
	 * @param Todo
	 * @return URI
	 */
	
	@PostMapping("/todo/addATodo")
	public ResponseEntity<Object> addATodo(@RequestBody Todo todo){
		Todo resTodo = todoService.save(todo);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(resTodo.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
}

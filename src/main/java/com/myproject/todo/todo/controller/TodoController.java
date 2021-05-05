package com.myproject.todo.todo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
		return todoService.getAllTodo();
	}


	/*
	 * @param Todo id
	 * @return get todo with the id
	 *
	 * POSTMAN working confirmed
	 */
	@GetMapping("/todo/getATodo/{id}")
	public Todo getTodoById(@PathVariable Integer id) {
		return todoService.getTodoById(id);
	}


	/*
	 * @param Todo
	 * @return URI
	 *
	 * POSTMAN working confirmed
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

	/*
		*Api endpoint is for deleting the Todos
		* @param id
		* @return void
	 */
	@DeleteMapping("/todo/deleteATodo/{id}")
	public void deleteTodoById(@PathVariable Integer id)
	{
		todoService.deleteById(id);
	}

	/*
		*Api for marking a Todo as complete
		* @param id
		* @return the required Todo
	 */
	@PostMapping("/todo/markComplete/{id}")
	public Todo markTodoAsComplete(@PathVariable int id){
		return todoService.markTodoAsComplete(id);
	}

	/*
	 *Api for marking a Todo as complete
	 * @param id
	 * @return the required Todo
	 */
	@PostMapping("/todo/markInComplete/{id}")
	public Todo markTodoAsInComplete(@PathVariable int id){
		return todoService.markTodoAsIncomplete(id);
	}

}

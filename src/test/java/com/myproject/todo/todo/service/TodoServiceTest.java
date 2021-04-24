package com.myproject.todo.todo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.myproject.todo.todo.model.Todo;

public class TodoServiceTest {
	
	//@InjectMocks
	
	TodoService testService = null;
	
	@Test
	public void testSave(){
		
		Todo testTodo = new Todo();
		testTodo.setDate(new Date());
		testTodo.setTask("Testing Task");
		
		testService = new TodoService();
		
		testTodo.setId(6);
		Todo output = testService.save(testTodo);
	
		assertEquals(output.getId(),testTodo.getId());
		assertEquals(output.getDate(),testTodo.getDate());
		assertEquals(output.getTask(),testTodo.getTask());
	
	
	}
}

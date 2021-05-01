package com.myproject.todo.todo.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.junit.Before;
import org.junit.Test;

import com.myproject.todo.todo.model.Todo;


public class TodoServiceTest {
	
	//@InjectMocks
	/*
	 * Junit tests for Todo Service Test 
	 */
	
	TodoService testService = null;
	
	@Before
	public void setup()
	{
		testService = new TodoService();
	}
	
	
	@Test
	public void testSave(){  //Testing the save function
		
		Todo testTodo = new Todo();
		testTodo.setDate(new Date());
		testTodo.setTask("Testing Task");
		
		
		
		testTodo.setId(6);
		Todo output = testService.save(testTodo);
	
		//CHecking like this as no object are equal by default 
		assertEquals(output.getId(),testTodo.getId());
		assertEquals(output.getDate(),testTodo.getDate());
		assertEquals(output.getTask(),testTodo.getTask());
	}
	
	@Test
	public void testshowAllTasks() {
		List<Todo> TodoOutputList = new ArrayList<>();
		TodoOutputList = testService.showAllTasks();
		
		assertNotNull(testService.showAllTasks());
	}
	
	@Test
	public void testshowATodo() {
		
		
		//Todo output = testService.showATodo(3);
		assertNotNull(testService.showATodo(3));
		assertNull(testService.showATodo(7));
	}
	
	//need the help for delete
	@Test
	public void testDeleteById() {
		assertNotNull(testService.deleteById(3));
		
		List<Todo> TodoList = new ArrayList<>();
		TodoList = testService.showAllTasks();
		assertNull(testService.showATodo(3));
	}
	
}

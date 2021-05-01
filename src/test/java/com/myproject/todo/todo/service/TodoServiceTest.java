package com.myproject.todo.todo.service;

import com.myproject.todo.todo.model.Todo;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TodoServiceTest {

	TodoService testService = null;
	
	@Before
	public void setup()
	{
		testService = new TodoService();
	}
	
	
	@Test
	public void testSave(){
		Todo testTodo = new Todo();

		testTodo.setDate(new Date());
		testTodo.setTask("Testing Task");
		testTodo.setId(6);

		Todo output = testService.save(testTodo);

		assertEquals(output.getId(),testTodo.getId());
		assertEquals(output.getDate(),testTodo.getDate());
		assertEquals(output.getTask(),testTodo.getTask());
	}
	
	@Test
	public void testGetAllTodo() throws NoSuchFieldException, IllegalAccessException {
		Field f = (testService).getClass().getDeclaredField("count");
		f.setAccessible(true);
		int count = f.getInt(testService);

		assertEquals(count,testService.getAllTodo().size());
	}
	
	@Test
	public void testGetTodoByIdPositive() {
		assertNotNull(testService.getTodoById(3));
	}

	@Test(expected = ObjectWithGivenIdNotFoundException.class)
	public void testGetTodoByIdNegative() {
		assertNotNull(testService.getTodoById(-1));
	}

	@Test
	public void testDeleteByIdPositive() {
		assertTrue(testService.deleteById(1));

	}

	@Test
	public void testDeleteByIdNegative() {
		assertFalse(testService.deleteById(-1));

	}
	
}

package com.myproject.todo.todo.dto;

import java.util.*;

import org.springframework.stereotype.Component;

import com.myproject.todo.todo.model.Todo;

@Component
public class TodoDto {
	
    private static ArrayList<Todo> TodoArray = new ArrayList<>();
	
    private static int count=3;
    
    static {
    	TodoArray.add(new Todo(1,new Date(), "1st Task"));
    	TodoArray.add(new Todo(2,new Date(), "2nd Task"));
    	TodoArray.add(new Todo(3,new Date(), "3rd Task"));
    }
    
    public List<Todo> showAllTasks()
    {
    	return TodoArray;
    }
    
    public Todo showATodo(int TodoId)
    {
    	for(Todo todo:TodoArray)
    	{
    		if(todo.getId()==TodoId)
    			return todo;
    	}
    	return null;
    }
    
    public Todo save(Todo todo)
    {
    	if(todo.getId()==null) {
    		todo.setId(++count);
    	}
    	TodoArray.add(todo);
    	return todo;
    }
    
    public Todo deleteById(int id)
    {
    	Iterator<Todo> iterator = TodoArray.iterator();
    	while(iterator.hasNext()) {
    		Todo todo = iterator.next();
    		if(todo.getId()==id)
    			iterator.remove();
    			return todo;
    	}
    	return null;
    }
}

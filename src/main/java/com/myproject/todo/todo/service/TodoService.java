package com.myproject.todo.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.myproject.todo.todo.model.Todo;


@Component
public class TodoService {
	
    private static ArrayList<Todo> TodoArray = new ArrayList<>();
	
    private static int count=3;
    
    static {
    	TodoArray.add(new Todo(1,new Date(), "1st Task"));
    	TodoArray.add(new Todo(2,new Date(), "2nd Task"));
    	TodoArray.add(new Todo(3,new Date(), "3rd Task"));
    	
//    	Todo t = new Todo();
//    	t.getId();
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
    	Todo resTodo = new Todo();
    	if(todo.getId()==null) {
    		 		
    		resTodo.setId(++count);
    		  	}
    	else {
    		resTodo.setId(todo.getId());
    	}
    	
    	
    	resTodo.setDate(todo.getDate());
		resTodo.setTask(todo.getTask());
    	TodoArray.add(resTodo);
    	return resTodo;
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

package com.myproject.todo.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.myproject.todo.todo.model.Todo;

/*
 * This is service class of the Todo Object 
 * 
 * Controls the opertaion that is occurring in the backend 
 */


@Component
public class TodoService {
	
    private static ArrayList<Todo> TodoList = new ArrayList<>();  //List of Todo
	
    private static int count=3;
    
    /*
     * Storing initial dummy data 
     */
    
    static {
    	TodoList.add(new Todo(1,new Date(), "1st Task")); 
    	TodoList.add(new Todo(2,new Date(), "2nd Task"));
    	TodoList.add(new Todo(3,new Date(), "3rd Task"));
    	
//    	Todo t = new Todo();
//    	t.getId();
    }
    
    /*
     * @param None
     * @return TodoList
     */
    public List<Todo> showAllTasks()
    {
    	return TodoList;
    }
    
    /*
     * @param None
     * @return TodoList
     */
    public Todo showATodo(int TodoId)
    {
    	for(Todo todo:TodoList)
    	{
    		if(todo.getId()==TodoId)
    			return todo;
    	}
    	return null;
    }
    
    /*
     * @param None
     * @return TodoList
     */
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
    	TodoList.add(resTodo);
    	return resTodo;
    }
    
    /*
     * @param None
     * @return TodoList
     */
    
    public Todo deleteById(int id)
    {
    	Iterator<Todo> iterator = TodoList.iterator();
    	while(iterator.hasNext()) {
    		Todo todo = iterator.next();
    		if(todo.getId()==id)
    			iterator.remove();
    			return todo;
    	}
    	return null;
    }
	
	
	
}

package com.myproject.todo.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.myproject.todo.todo.model.Todo;

/**
 * Please Add proper Doc comments based on th comments below.
 */

@Component
public class TodoService {
	
    private static ArrayList<Todo> todoList = new ArrayList<>();
	
    private static int count=3;
    
    /*
     * Storing initial dummy data.
     */
    
    static {
    	todoList.add(new Todo(1,new Date(),"1st Task",false));
    	todoList.add(new Todo(2,new Date(),"2nd Task",false));
    	todoList.add(new Todo(3,new Date(),"3rd Task",false));
    }
    
    /* Method used to extract all Todo Objects currently stored in the list.
     *
     * @return todoList storing all Todo Objects.
     */
    public List<Todo> getAllTodo(){
    	return todoList;
    }
    
	/**
	 * Method used to extract an Object from the list based on the id provided in the parameter.
	 * It returns the Object with the given ID if present. Else throws an exception.
	 *
	 * @param todoId The id of the Todo Object that needs to be searched.
	 * @return The Todo Object with the given id.
	 */
    public Todo getTodoById(Integer todoId) throws ObjectWithGivenIdNotFoundException {
    	return todoList.stream().
				filter(x -> x.getId()==todoId)
				.findAny()
				.orElseThrow(() -> new ObjectWithGivenIdNotFoundException(todoId));
    }
    

	/**
	 * Method used to save an request Todo Object in the list.
	 * If the provided id of the object is null, the id set the an increment of count and saved in the list.
	 * Else if the Object is set as it is.
	 *
	 * @param todo The todo Object that needs to be saved.
	 * @return The saved object.
	 */
    public Todo save(Todo todo){
		++count;
    	if(todo.getId()==null) {
    		 todo.setId(count);
		}
		todoList.add(todo);
		return todo;

    }

    /*
    * Method is used to mark a Todo as complete
    *
    * @param id The id of the todo for which the Todo is to be marked as complete
    * @return The todo returned
    *
    */
    public Todo markTodoAsComplete(Integer todoid) throws ObjectWithGivenIdNotFoundException {
		Todo todo = getTodoById(todoid);
		todo.markComplete();
		return todo;
	}

	/*
	* Method is used to mark the Todo as incomplete
	*
	* @param id The id of the todo for which the Todo is to be marked as complete
	 * @return The todo returned
	*/
	public Todo markTodoAsIncomplete(Integer todoid) throws ObjectWithGivenIdNotFoundException{
		Todo todo = getTodoById(todoid);
		todo.markIncomplete();
		return todo;
	}


    /* Method used to delete an object from the list based on the id field value.
     * If the object is deleted the count is set to the size of the list to maintain consistency.
     *
     * @param id The id of the object that needs to be deleted.
     * @return boolean True if object with that id exists and was successfully deleted.
     * @return boolean False if object with that id does not exists.
     */
    
    public boolean deleteById(int id){
    	todoList.removeIf(x -> x.getId()==id);
    	if (count!= todoList.size()){
    		count = todoList.size();
    		return true;
		}
    	return false;
    }

}

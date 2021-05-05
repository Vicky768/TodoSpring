package com.myproject.todo.todo.model;

import java.util.Date;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/* 
 * This is the model class
 * 
 * Here we have declared the required variables of the Todo Object 
 * 
 * id
 * Date
 * String
 *
 * isComplete
 */

public class Todo {
	
	private Integer id; //id of Task assigned
	private Date date;  //date when the Task has been assigned 
	private String task; //the task
	private boolean isComplete; //this is the parameter for checking if the Todo Task has been completed

	public Integer getId() {
		return id;
	}

	public void setId(@Nullable Integer id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTask() {
		return task;
	}

	public void setTask(@NonNull String task) {
		this.task = task;  //String can never be null as Todo is main focus we are focusing on
	}

	public boolean getCompleteStatus() {
		return isComplete;
	}

	public void markComplete(){
		this.isComplete=true;
	}

	public void markIncomplete(){
		this.isComplete=false;
	}

	public Todo() {}

	public Todo(int id, Date date, String task, boolean isComplete) {
		
		this.id = id;
		this.date = date;
		this.task = task;
		this.isComplete = isComplete;
	}

	@Override
	public String toString() {
		return "Todo{" +
				"id=" + id +
				", date=" + date +
				", task='" + task + '\'' +
				", isComplete=" + isComplete +
				'}';
	}
}

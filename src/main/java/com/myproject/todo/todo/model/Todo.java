package com.myproject.todo.todo.model;

import java.util.Date;

public class Todo {
	
	private Integer id;
	private Date date; 
	private String task;
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
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
	public void setTask(String task) {
		this.task = task;
	}
	
	protected Todo()
	{
		
	}
	
	public Todo(int id, Date date, String task) {
		super();
		this.id = id;
		this.date = date;
		this.task = task;
	} 
	
	@Override
	public String toString() {
		return "Todo [TodoId=" + id + ", date=" + date + ", task=" + task + "]";
	}
}

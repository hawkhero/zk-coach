/* 
	Description:
		ZK Essentials
	History:
		Created by dennis

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package zkcoach.mvvm.tutorial.service;

import java.util.*;

import zkcoach.mvvm.tutorial.entity.Todo;

public class TodoListService {

	static int todoId = 0;
	static List<Todo> todoList = new ArrayList<Todo>();  
	static{
		todoList.add(new Todo(todoId++,"寫一個待辦清單",1,dayAfter(5),"$1,000"));
		todoList.add(new Todo(todoId++,"看到賣西瓜的，就買一個",2,null,null));
		todoList.add(new Todo(todoId++,"女友說什麼就做什麼",3,dayAfter(10),null));
	}
	
	
	private static Date dayAfter(int d){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, d);
		return c.getTime();
	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized List<Todo>getTodoList() {
		List<Todo> list = new ArrayList<Todo>();
		for(Todo todo:todoList){
			list.add(Todo.clone(todo));
		}
		return list;
	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized Todo getTodo(Integer id){
		int size = todoList.size();
		for(int i=0;i<size;i++){
			Todo t = todoList.get(i);
			if(t.getId().equals(id)){
				return Todo.clone(t);
			}
		}
		return null;
	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized Todo saveTodo(Todo todo){
		todo = Todo.clone(todo);
		todo.setId(todoId++);
		todoList.add(todo);
		return todo;
	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized Todo updateTodo(Todo todo){
		if(todo.getId()==null){
			throw new IllegalArgumentException("cann't save a null-id todo, save it first");
		}else{
			todo = Todo.clone(todo);
			int size = todoList.size();
			for(int i=0;i<size;i++){
				Todo t = todoList.get(i);
				if(t.getId().equals(todo.getId())){
					todoList.set(i, todo);
					return todo;
				}
			}
			throw new RuntimeException("Todo not found "+todo.getId());
		}
	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized void deleteTodo(Todo todo){
		if(todo.getId()!=null){
			int size = todoList.size();
			for(int i=0;i<size;i++){
				Todo t = todoList.get(i);
				if(t.getId().equals(todo.getId())){
					todoList.remove(i);
					return;
				}
			}
		}
	}

}

package zkcoach.mvvm.tutorial.controller;

import java.util.*;

import org.zkoss.bind.annotation.*;

import zkcoach.mvvm.tutorial.entity.Todo;
import zkcoach.mvvm.tutorial.service.TodoListService;

public class TodoEditorViewModel{
	
	private Todo todo; //正在編輯的待辦事項
	private static Integer[] PRIORITIES = {1,2,3};
	private TodoListService todoListService = new TodoListService();
	
	/**
	 * 透過 @ScopePara 抓取存在 Desktop attribute 中的 Todo
	 * @param todo
	 * TODO, 2-5, 定義一個 init method
	 */
	
	/**
	 * 儲存編輯後的待辦事項
	 * TODO, 2-5,
	 */
	@Command
	public void save(){
		todoListService.updateTodo(todo);
	}
	
	//以下為 data binding 所需的 getter & setter
	public List<Integer> getPriorityList(){
		return Arrays.asList(PRIORITIES);
	}
	
	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}
	
}
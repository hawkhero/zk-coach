package zkcoach.mvvm.tutorial.controller;

import java.io.Serializable;

import org.zkoss.bind.annotation.*;

import zkcoach.mvvm.tutorial.entity.Todo;

/**
 * 控制頁面導向。
 * @author hawk
 *
 */
public class MyTodoListViewModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String currentPage = "todoList.zul";
	
	@GlobalCommand @NotifyChange("currentPage")
	public void navigate(@BindingParam("page") String page, @BindingParam("todo") Todo todo){
		currentPage = page;
	}
	
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
}

package zkcoach.mvvm.tutorial.controller;

import java.io.Serializable;

import org.zkoss.bind.annotation.*;

import zkcoach.mvvm.tutorial.entity.Todo;

/**
 * 控制頁面導向。
 * @author hawk
 *
 */
public class MyTodoListViewModel {
	private String title = "我的待辦清單";
	private String currentPage = "todoList.zul";

	//TODO, 4, global command 接受 page 參數，設定 currentPage

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getTitle() {
		return title;
	}
}
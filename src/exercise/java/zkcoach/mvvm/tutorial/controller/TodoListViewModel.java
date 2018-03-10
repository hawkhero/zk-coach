package zkcoach.mvvm.tutorial.controller;

import java.util.List;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zul.ListModelList;

import zkcoach.mvvm.tutorial.entity.Todo;
import zkcoach.mvvm.tutorial.service.TodoListService;

public class TodoListViewModel {

    //應用程式邏輯
    private TodoListService todoListService = new TodoListService();

    //畫面上所需要呈現或儲存的資料(view state)
    private String subject;
    private ListModelList<Todo> todoListModel;
    private Todo selectedTodo;

    @Init // 初始化
    public void init() {
        //從後端抓資料
        List<Todo> todoList = todoListService.getTodoList();
        //建議使用 ListModelList 可以優化繪製效率，避免每次都重新繪製所有資料
        todoListModel = new ListModelList<Todo>(todoList);
    }

    //TODO, 10, 實作 addTodo command
    /**
     * 切換完成狀態
     *
     * @param todo
     * TODO, 2-5, 實作
     */

    //TODO, 7, 實作 deleteTodo

    //TODO, 4, 實作 edit todo


    //以下為 data binding 所需的 getter & setter
    public ListModelList<Todo> getTodoListModel() {
        return todoListModel;
    }

    public Todo getSelectedTodo() {
        return selectedTodo;
    }

    public void setSelectedTodo(Todo selectedTodo) {
        this.selectedTodo = selectedTodo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
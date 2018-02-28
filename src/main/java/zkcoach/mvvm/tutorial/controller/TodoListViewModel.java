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

    @Command //@Command 用來宣告此方法為命令 (command)
    @NotifyChange("subject") //@NotifyChange 通知 ZK 更新哪些 property
    public void addTodo() {
        Todo newTodo = todoListService.saveTodo(new Todo(subject));
        //更新頁面資料，無需用 @NotifyChange 通知 ZK 我們改變了 todoListModel，它自行會通知元件繪製新增的一筆
        todoListModel.add(newTodo);
        //清空輸入，方便輸入下一個事項
        subject = "";
    }

    /**
     * 切換完成狀態
     *
     * @param todo
     */
    @Command
    public void toggleComplete(@BindingParam("todo") Todo todo) {
        todoListService.updateTodo(todo);
    }

    @Command
    public void deleteTodo(@BindingParam("todo") Todo todo) {
        //刪除後端資料
        todoListService.deleteTodo(todo);
        //刪除畫面上的資料
        todoListModel.remove(todo);
//        System.out.println("deleteTodo");
    }

    @Command
    public void edit(@ContextParam(ContextType.DESKTOP) Desktop desktop) {
        desktop.setAttribute("todo", selectedTodo); //存入 desktop 讓編輯頁面存取
    }


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
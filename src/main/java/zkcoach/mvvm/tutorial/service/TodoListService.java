package zkcoach.mvvm.tutorial.service;

/**
 * 實作操作待辦事項清單的 CRUD 邏輯
 */

import java.util.*;

import zkcoach.mvvm.tutorial.entity.Todo;

public class TodoListService {

    static int todoId = 0;
    static List<Todo> todoList = new ArrayList<Todo>(); //模擬後端資料庫查詢的結果

    static {
        todoList.add(new Todo(todoId++, "寫一個待辦清單", 1, toadyAfter(5), "$1,000"));
        todoList.add(new Todo(todoId++, "看到賣西瓜的，就買一個", 2, null, null));
        todoList.add(new Todo(todoId++, "幫女友按摩", 3, toadyAfter(10), null));
    }


    /**
     * @param d 天數
     * @return 傳回一個今天之後幾天的日期
     */
    private static Date toadyAfter(int d) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, d);
        return c.getTime();
    }

    public synchronized List<Todo> getTodoList() {
        List<Todo> list = new ArrayList<Todo>();
        for (Todo todo : todoList) {
            list.add(Todo.clone(todo));
        }
        return list;
    }


    public synchronized Todo getTodo(Integer id) {
        int size = todoList.size();
        for (int i = 0; i < size; i++) {
            Todo t = todoList.get(i);
            if (t.getId().equals(id)) {
                return Todo.clone(t);
            }
        }
        return null;
    }

    /**
     * 使用 synchronized 是為了避免多執行緒同時存取靜態變數 todoList 產生不一致的結果
     **/
    public synchronized Todo saveTodo(Todo todo) {
        todo = Todo.clone(todo);
        todo.setId(todoId++);
        todoList.add(todo);
        return todo;
    }


    public synchronized Todo updateTodo(Todo todo) {
        if (todo.getId() == null) {
            throw new IllegalArgumentException("cann't save a null-id todo, save it first");
        } else {
            todo = Todo.clone(todo);
            int size = todoList.size();
            for (int i = 0; i < size; i++) {
                Todo t = todoList.get(i);
                if (t.getId().equals(todo.getId())) {
                    todoList.set(i, todo);
                    return todo;
                }
            }
            throw new RuntimeException("Todo not found " + todo.getId());
        }
    }


    public synchronized void deleteTodo(Todo todo) {
        if (todo.getId() != null) {
            int size = todoList.size();
            for (int i = 0; i < size; i++) {
                Todo t = todoList.get(i);
                if (t.getId().equals(todo.getId())) {
                    todoList.remove(i);
                    return;
                }
            }
        }
    }

}

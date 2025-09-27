package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true) {
            todoListService.showTodoList();

            System.out.println("Menu : ");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("x. Exit");

            var input = InputUtil.input("Enter choice");

            if (input.equals("1")){
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
    public void addTodoList(){
        System.out.println("Add Todo List");

        var todo = InputUtil.input("Todo (x for cancel)");

        if (todo.equals("x")){
            // cancel
        } else {
            todoListService.addTodoList(todo);
        }
    }
    public void removeTodoList(){

    }

}

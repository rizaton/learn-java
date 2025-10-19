package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();

        System.out.println("Todo List: ");
        for (var i = 0; i < model.length; i++) {
            var todoList = model[i];
            var listNumber = i + 1;

            if (todoList != null){
                System.out.println(listNumber + ". " + todoList.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todoList = new Todolist(todo);
        todoListRepository.add(todoList);
        System.out.println("Success adding Todo : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success) {
            System.out.println("Success remove todo : " + number);
        } else {
            System.out.println("Failed remove todo : " + number);
        }

    }
}

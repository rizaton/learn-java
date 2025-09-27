package test.service;

import entity.TodoList;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testShowTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Learn Basic Java");
        todoListRepository.data[1] = new TodoList("Learn Basic OOP");
        todoListRepository.data[2] = new TodoList("Learn Basic Standard Classes");


        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

}

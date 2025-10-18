package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.TodoList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodoListRepositoryImpl implements TodoListRepository{

    public TodoList[] data = new TodoList[10];

    private HikariDataSource dataSource;

    public TodoListRepositoryImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull(){
        var isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                // there's still empty in model
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull(){
        // If full, model get resized two times
        if (isFull()){
            var temp = data;
            data = new TodoList[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todoList) {
        String sql = "INSERT INTO todolist(todo) VALUES (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, todoList.getTodo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean remove(Integer number) {
        if ((number - 1) >= data.length) { return false; }
        else if (data[number - 1] == null) { return false; }
        else {
            for (int i = (number - 1); i < data.length; i++) {
                if(i == (data.length - 1)){
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}

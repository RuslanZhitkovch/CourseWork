package com.example.coursework;

import com.example.coursework.User;
import com.example.coursework.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    Connection connection = DBHandler.getConnection();



    @Override
    public List<User> gelAll()
    {
        List<User> users;

        try {
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(resultSet.getInt("idusers"),
                        resultSet.getString("name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("email"),
                        resultSet.getString("age"),
                        resultSet.getString("job_title"),
                        resultSet.getString("role"),
                        resultSet.getString("access"),
                        resultSet.getString("password")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public void deleteById(Integer id) {
        String sqlQuery  = "DELETE FROM users WHERE idusers = " + id;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    @Override
    public void add(User user)
    {
        String sqlQuery = "INSERT INTO users (name, second_name, email, age, job_title, role,access,password) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSecond_name());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAge());
            statement.setString(5, user.getJob_title());
            statement.setString(6, user.getRole());
            statement.setString(7, user.getAccess());
            statement.setString(8, user.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        String sqlQuery = "UPDATE users SET name = ?, second_name = ?, email = ?, age = ?, job_title = ?, role = ?, access = ?, password = ? WHERE idusers = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSecond_name());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAge());
            statement.setString(5, user.getJob_title());
            statement.setString(6, user.getRole());
            statement.setString(7, user.getAccess());
            statement.setString(8, user.getPassword());
            statement.setInt(9, user.getIdusers());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

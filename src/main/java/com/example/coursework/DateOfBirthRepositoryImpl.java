package com.example.coursework;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DateOfBirthRepositoryImpl implements DateOfBirthRepository
{
    Connection connection = DBHandler.getConnection();


    @Override
    public void addDateOfBirth(DateOfBirth dateOfBirth)
    {

        String sqlQuery = "INSERT INTO date_of_birth (day, month, year) VALUES(?, ?, ?)";
        try
        {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, dateOfBirth.getDay());
            statement.setString(2, dateOfBirth.getMonth());
            statement.setString(3,dateOfBirth.getYear());



            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

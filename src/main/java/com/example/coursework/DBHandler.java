package com.example.coursework;
// Класс для подключение к БД. Что-то записывать, читать.

import java.sql.*;

public class DBHandler extends Configs
{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException
    {



        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort +"/" +dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");  // Имя драйвера, который будем использовать
        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);
        return dbConnection;
    }


    public void addUserToDBAfterRegister(String name, String second_name, String email, String age, String job_title, String role, String access, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_NAME + "," +
                Const.USER_SECOND_NAME + "," +
                Const.USER_EMAIL + "," +
                Const.USER_AGE + "," +
                Const.USER_JOB_TITLE + "," +
                Const.USER_ROLE+ "," +
                Const.USER_ACCESS + "," +
                Const.USER_PASSWORD + ")" +
                "VALUES(?,?,?,?,?,?,?,?)";

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,name);
            prSt.setString(2,second_name);
            prSt.setString(3,email);
            prSt.setString(4,age);
            prSt.setString(5,job_title);
            prSt.setString(6,role);
            prSt.setString(7,access);
            prSt.setString(8,password);

            prSt.executeUpdate();

        } catch(SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }


    }



    public ResultSet getUser(User user)    // ResultSeT - Возвращает массив данных пользователя из БД
    {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=? AND " + Const.USER_PASSWORD + "=?";

        try{

            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1,user.getEmail());
            prSt.setString(2,user.getPassword());

            resSet =  prSt.executeQuery();   // метод кот. получает данные из БД
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)

        {
            e.printStackTrace();
        }



        return resSet;

    }




}

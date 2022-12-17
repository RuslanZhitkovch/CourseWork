package com.example.coursework;
// Класс для подключение к БД. Что-то записывать, читать.

import java.sql.*;

public class DBHandler extends Configs
{
    static Connection dbConnection;

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException
    {



        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort +"/" +dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);
        return dbConnection;
    }



    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            return  DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "24101979");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void addDateOfBirthAfterRegister(Integer day, String month, String year)
    {
        String insert = "INSERT INTO "+ Const.DATE_OF_BIRTH_TABLE + "("+
                Const.DAY + "," +
                Const.MONTH + "," +
                Const.YEAR + ")" +
            "VALUES(?,?,?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1,day);
            prSt.setString(2,month);
            prSt.setString(3,year);

            prSt.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);

        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }



    public void addUserToDBAfterRegister(String name, String second_name, String email, String code_date_of_birth, String job_title, String role, String access, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_NAME + "," +
                Const.USER_SECOND_NAME + "," +
                Const.USER_EMAIL + "," +
                Const.USER_CODE_DATE_OF_BIRTH + "," +
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
            prSt.setString(4,code_date_of_birth);
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


        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=? AND " + Const.USER_PASSWORD + "=? AND " + Const.USER_ACCESS + "=? AND " + Const.USER_ROLE + " =?";

        try{

            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1,user.getEmail());
            prSt.setString(2,user.getPassword());
            prSt.setString(3,user.getAccess());
            prSt.setString(4,user.getRole());

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



    public  ResultSet getLastDateOfBirthID(DateOfBirth dateOfBirth)
    {
        ResultSet resSet = null;

        Connection connection = DBHandler.getConnection();
        String select = "SELECT idDateOfBirth FROM date_of_birth ORDER BY idDateOfBirth DESC LIMIT 1";

       try {
           PreparedStatement prSt = getDbConnection().prepareStatement(select);
           resSet =  prSt.executeQuery();   // метод кот. получает данные из БД
       }
       catch (SQLException r)
       {
           r.printStackTrace();
       }
       catch (ClassNotFoundException r)

       {
          r.printStackTrace();
       }


       return resSet;
    }











    public static void updateUserAccessToZero(int id)
    {
        Connection connection = DBHandler.getConnection();
        String sqlQuery = "UPDATE users SET access = 0 WHERE idusers = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

















}

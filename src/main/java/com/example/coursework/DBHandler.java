package com.example.coursework;
// Класс для подключение к БД. Что-то записывать, читать.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHandler extends Configs
{
  Connection dbConnection;

  public Connection getDbConnectio() throws ClassNotFoundException, SQLException
  {
    String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

   Class.forName("com.mysql,jdbc.Driver");  // Имя драйвера, который будем использовать
      dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);
      return dbConnection;
  }



}

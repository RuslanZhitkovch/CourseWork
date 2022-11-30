package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loginController {



   public String CURRENT_ACCESS = "0";

   public void set_current_access(String value)
   {
       this.CURRENT_ACCESS = value;
   }


    @FXML
    private Label failedLoginTextButton;

    @FXML
    private TextField enterLoginButton;

    @FXML
    private PasswordField enterPasswordButon;

    @FXML
    private Button goToRegisterButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize1()
    {

        loginSignUpButton.setOnAction(event-> {
            String loginText = enterLoginButton.getText().trim();
            String loginPassword = enterPasswordButon.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")) // если пароль и логин не пустые
            {
                try {
                    loginUser(loginText,loginPassword);
                } catch (IOException | SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else
            {
                failedLoginTextButton.setText("Ошибка входа. Повторите попытку.");
                System.out.println("Кто-то пытается войти с пустыми полями логина и пароля.");
            }


        });




        goToRegisterButton.setOnAction(event ->
                {

                    goToRegisterButton.getScene().getWindow().hide();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("registerManager.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Scene scene = new Scene(root);
                    Stage primaryStage = new Stage();
                    primaryStage.setTitle("hello");
                    primaryStage.setScene(scene);
                    primaryStage.initModality(Modality.WINDOW_MODAL);
                    primaryStage.show();




                }
        );
    }

    private void loginUser(String emailText, String loginPassword) throws IOException, SQLException
    {

        User user = new User();
        user.setEmail(emailText);       // устанавливаем юзеру email из кнопки
        user.setPassword(loginPassword);
        user.setAccess("1");








        DBHandler dbHandler = new DBHandler();
        ResultSet result =  dbHandler.getUser(user);
        System.out.println(user.getAccess());

        int counter = 0;

        try {
            while (result.next()) {
                counter++;


            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        if (counter >=1  )
        {
            loginSignUpButton.getScene().getWindow().hide();
          Parent root = FXMLLoader.load(getClass().getResource("chooseTest.fxml"));
          Scene scene = new Scene(root);
          Stage primaryStage = new Stage();
          primaryStage.setTitle("hello");
          primaryStage.setScene(scene);
          primaryStage.initModality(Modality.WINDOW_MODAL);
          primaryStage.show();
        }

        else {


            System.out.println("incorrect password");
            loginSignUpButton.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("incorrectPasswordOrAccess.fxml"));

            Scene scene = new Scene(root);

            Stage primaryStage = new Stage();

            primaryStage.setTitle("hello");

            primaryStage.setScene(scene);

            primaryStage.initModality(Modality.WINDOW_MODAL);

            primaryStage.show();


        }


    }

}

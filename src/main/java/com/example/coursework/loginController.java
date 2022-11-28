package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loginController {






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
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else
            {
                System.out.println("Ошибка! Логин и пароль пустые!");
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

    private void loginUser(String emailText, String loginPassword) throws IOException {

        DBHandler dbHandler = new DBHandler();
        User user = new User();
        user.setEmail(emailText);       // устанавливаем юзеру email из кнопки
        user.setPassword(loginPassword);
        ResultSet result =  dbHandler.getUser(user);

        int counter = 0;


        try {
            while (result.next()) {
                counter++;


            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        if (counter >=1)
        {
            loginSignUpButton.getScene().getWindow().hide();

          Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
          Scene scene = new Scene(root);
          Stage primaryStage = new Stage();
          primaryStage.setTitle("hello");
          primaryStage.setScene(scene);
          primaryStage.initModality(Modality.WINDOW_MODAL);
          primaryStage.show();
        }

        else {
            loginSignUpButton.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("loginManager.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("hello");
            primaryStage.setScene(scene);
            primaryStage.initModality(Modality.WINDOW_MODAL);
            primaryStage.show();
        }


    }

}

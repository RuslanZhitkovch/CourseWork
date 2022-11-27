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
                loginUser(loginText,loginPassword);
            }
            else
            {
                System.out.println("Ошибка! Логин и пароль пустые!");
            }


        });




        goToRegisterButton.setOnAction(event ->
                {
                    goToRegisterButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("registerManager.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();

                }
        );
    }

    private void loginUser(String emailText, String loginPassword)
    {

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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();


        }

        else {
            loginSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("loginManager.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }


    }

}

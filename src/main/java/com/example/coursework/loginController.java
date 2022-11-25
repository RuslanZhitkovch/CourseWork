package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


import java.io.IOException;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {


    public void openNewScene(String window)
    {
        goToRegisterButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

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
           openNewScene("registerManager.fxml");

       }
       );
    }

    private void loginUser(String loginText, String loginPassword)
    {

    }

}

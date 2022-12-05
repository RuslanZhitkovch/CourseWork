package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class registerController {

    @FXML
    private TextField ageButton;

    @FXML
    private Button confirmRegisterButton;

    @FXML
    private TextField emailButton;

    @FXML
    private TextField jobTitleButton;

    @FXML
    private TextField passwordButton;

    @FXML
    private TextField secondNameButton;

    @FXML
    private TextField usernameButton;

    @FXML
    private Text error_text;


    @FXML
    void initialize()
    {
        DBHandler dbHandler = new DBHandler();

        confirmRegisterButton.setOnAction(event->
        {

            if((secondNameButton.getText().length() < 5 || secondNameButton.getText().length() > 20) ||(passwordButton.getText().length() < 5 || passwordButton.getText().length() > 20) || (emailButton.getText().length() < 5 || emailButton.getText().length() > 20 ) || (usernameButton.getText().length() < 5 || usernameButton.getText().length() > 20)) // || or
            {
                error_text.setText("Не корректные данные");
                System.out.println("Не корректные данные");
            }
           else {


                try {
                    dbHandler.addUserToDBAfterRegister(usernameButton.getText(), secondNameButton.getText(), emailButton.getText(), ageButton.getText(), jobTitleButton.getText(), "0", "1", HashPassword.md5Custom(passwordButton.getText()));

                    confirmRegisterButton.getScene().getWindow().hide();
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

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}

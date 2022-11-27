package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    void initialize()
    {
        DBHandler dbHandler = new DBHandler();

        confirmRegisterButton.setOnAction(event->
        {
            try {
                dbHandler.addUserToDBAfterRegister(usernameButton.getText(), secondNameButton.getText(), emailButton.getText(), ageButton.getText(), jobTitleButton.getText(),"0", "1", passwordButton.getText());

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

            } catch (SQLException e)
            {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}

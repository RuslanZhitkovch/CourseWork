package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class aboutProgrammController {

    @FXML
    private Button goBackButton;

    @FXML
    private Button quitTheProgramButton;



    @FXML
    void initialize()
    {
        goBackButton.setOnAction(event -> {
            goBackButton.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("chooseTest.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("hello");
            primaryStage.setScene(scene);
            primaryStage.initModality(Modality.WINDOW_MODAL);
            primaryStage.show();
        });

        quitTheProgramButton.setOnAction(event -> {

            System.exit(0);

        });

    }



}



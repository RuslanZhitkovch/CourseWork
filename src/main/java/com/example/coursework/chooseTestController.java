package com.example.coursework;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;





public class chooseTestController {







    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aboutProgramButton;

    @FXML
    private Button cPlusPlusDeveloperButton;

    @FXML
    private Button databaseDesignerButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button hrManagerButton;

    @FXML
    private Button javaDeveloperButton;

    @FXML
    private Button pythonDeveloperButton;






    @FXML
    void initialize()
    {

        aboutProgramButton.setOnAction(event ->
        {





        });


        cPlusPlusDeveloperButton.setOnAction(event ->
        {


        });


        databaseDesignerButton.setOnAction(event ->
        {

        });


        exitButton.setOnAction(event ->
        {

        });


        hrManagerButton.setOnAction(event ->
        {

        });

        javaDeveloperButton.setOnAction(event -> {




            javaDeveloperButton.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
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

        pythonDeveloperButton.setOnAction(event -> {

        });






    }

}

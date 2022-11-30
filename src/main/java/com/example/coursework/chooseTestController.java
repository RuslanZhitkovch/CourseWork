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





public class chooseTestController
{


    public static int javaQuestions = 0;
    public static int pythonQuestions = 0;
    public static int ciPlusPlusQuestions = 0;
    public static int databaseQuestions = 0;
    public static int hrManager = 0;


    public static int getCiPlusPlusQuestions() {
        return ciPlusPlusQuestions;
    }

    public static int getHrManagerQuestions() {
        return hrManager;
    }

    public static int getDatabaseQuestions() {
        return databaseQuestions;
    }

    public void setJavaQuestions(int value)
    {
        this.javaQuestions = value;
    }

    public void setPythonQuestions(int value)
    {
        this.pythonQuestions = value;
    }

    public void setCiPlusPlusQuestions(int ciPlusPlusQuestions)
    {
        this.ciPlusPlusQuestions = ciPlusPlusQuestions;
    }

    public void setDatabaseQuestions(int databaseQuestions)
    {
        chooseTestController.databaseQuestions = databaseQuestions;
    }

    public void setHrManager(int hrManager)
    {
        chooseTestController.hrManager = hrManager;
    }




    public static int getJavaQuestions()
    {
        return javaQuestions;
    }



    public static int getPythonQuestions()
    {
        return pythonQuestions;
    }






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
            setCiPlusPlusQuestions(1);

            setDatabaseQuestions(0);
            setHrManager(0);
            setJavaQuestions(0);
            setPythonQuestions(0);


            cPlusPlusDeveloperButton.getScene().getWindow().hide();
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


        databaseDesignerButton.setOnAction(event ->
        {
            setDatabaseQuestions(1);

            setCiPlusPlusQuestions(0);
            setHrManager(0);
            setJavaQuestions(0);
            setPythonQuestions(0);


            databaseDesignerButton.getScene().getWindow().hide();
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




        hrManagerButton.setOnAction(event ->
        {
            setHrManager(1);

            setCiPlusPlusQuestions(0);
            setDatabaseQuestions(0);
            setJavaQuestions(0);
            setPythonQuestions(0);



            hrManagerButton.getScene().getWindow().hide();
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

        javaDeveloperButton.setOnAction(event -> {

            setJavaQuestions(1);

            setCiPlusPlusQuestions(0);
            setDatabaseQuestions(0);
            setHrManager(0);
            setPythonQuestions(0);






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

        pythonDeveloperButton.setOnAction(event ->
        {
            setPythonQuestions(1);

            setCiPlusPlusQuestions(0);
            setDatabaseQuestions(0);
            setHrManager(0);
            setJavaQuestions(0);



            pythonDeveloperButton.getScene().getWindow().hide();
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

        exitButton.setOnAction(event ->
        {


        });







    }

}

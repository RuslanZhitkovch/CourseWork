package com.example.coursework;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterDateOfBirthController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField MonthButton;

    @FXML
    private Button confirmRegisterButton;

    @FXML
    private TextField dayButton;

    @FXML
    private Text error_text;

    @FXML
    private TextField yearButton;

    @FXML
    void initialize()
    {

        DBHandler dbHandler = new DBHandler();

        confirmRegisterButton.setOnAction(event -> {



            if( (MonthButton.getText().equals("Октябрь" )) ||
                    (MonthButton.getText().equals("Ноябрь" )) ||
            (MonthButton.getText().equals("Декабрь" )) ||
                    (MonthButton.getText().equals("Январь" )) ||
                    (MonthButton.getText().equals("Февраль" )) ||
                    (MonthButton.getText().equals("Март" )) ||
                    (MonthButton.getText().equals("Апрель" )) ||
                    (MonthButton.getText().equals("Май" )) ||
                    (MonthButton.getText().equals("Июнь" )) ||
                    (MonthButton.getText().equals("Июль" )) ||
                    (MonthButton.getText().equals("Август" )) ||
                    (MonthButton.getText().equals("Сентябрь" )) ||

                    (MonthButton.getText().equals("Октября" )) ||
                    (MonthButton.getText().equals("Ноября" )) ||
                    (MonthButton.getText().equals("Декабря" )) ||
                    (MonthButton.getText().equals("Января" )) ||
                    (MonthButton.getText().equals("Февраля" )) ||
                    (MonthButton.getText().equals("Марта" )) ||
                    (MonthButton.getText().equals("Апреля" )) ||
                    (MonthButton.getText().equals("Мая" )) ||
                    (MonthButton.getText().equals("Июня" )) ||
                    (MonthButton.getText().equals("Июля" )) ||
                    (MonthButton.getText().equals("Августа" )) ||
                    (MonthButton.getText().equals("Сентября" ))
            )
            {
                dbHandler.addDateOfBirthAfterRegister(Integer.valueOf(dayButton.getText()), MonthButton.getText(), yearButton.getText());
                confirmRegisterButton.getScene().getWindow().hide();
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

            else {

                error_text.setText("Некорректные данные");


            }


        });



    }

}

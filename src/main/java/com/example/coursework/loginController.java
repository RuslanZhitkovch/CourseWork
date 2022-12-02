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

    public static int current_user_id;     // для последующего изменения access на 0.

    public static int getCurrent_user_id()
    {
        return current_user_id;
    }

    public void setCurrentUserId(int current_user_id)
    {
        this.current_user_id = current_user_id;
    }

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
                    primaryStage.setTitle("Окно регистрации");
                    primaryStage.setScene(scene);
                    primaryStage.initModality(Modality.WINDOW_MODAL);
                    primaryStage.show();




                }
        );
    }

    private void loginUser(String emailText, String loginPassword) throws IOException, SQLException
    {

        User admin = new User();
        admin.setEmail(emailText);       // устанавливаем юзеру email из кнопки
        admin.setPassword(loginPassword);
        admin.setAccess("1");  // для проверки может ли аккаунт пройти тест
        admin.setRole("1");  // для проверки на админа








        DBHandler dbHandler = new DBHandler();
        ResultSet result =  dbHandler.getUser(admin);





        int counter = 0;

        try
        {
            while (result.next())
            {
                counter++;


            }
        }




        catch (SQLException e)
        {
            e.printStackTrace();
        }




        if (counter >=1  )
        {



          loginSignUpButton.getScene().getWindow().hide();
          Parent root = FXMLLoader.load(getClass().getResource("adminPanel.fxml"));
          Scene scene = new Scene(root);
          Stage primaryStage = new Stage();
          primaryStage.setTitle("hello");
          primaryStage.setScene(scene);
          primaryStage.initModality(Modality.WINDOW_MODAL);
          primaryStage.show();
        }






        User user = new User();
        user.setEmail(emailText);       // устанавливаем юзеру email из кнопки
        user.setPassword(loginPassword);
        user.setAccess("1");  // для проверки может ли аккаунт пройти тест
        user.setRole("0");  // для проверки может ли аккаунт пройти тест




        DBHandler dbHandlerUser = new DBHandler();
        ResultSet resultUser =  dbHandlerUser.getUser(user);





        int counterUser = 0;

        try
        {
            while (resultUser.next())
            {
                int q = resultUser.getInt(1);
                System.out.println("Current id is: "+ q);
                setCurrentUserId(q);
                counterUser++;


            }
        }




        catch (SQLException e)
        {
            e.printStackTrace();
        }

        System.out.println(current_user_id);
        System.out.println(getCurrent_user_id());

        if (counterUser >=1  )
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





        if (counterUser <1 && counter <1)
        {


            System.out.println("incorrect password");
            loginSignUpButton.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("incorrectPasswordOrAccess.fxml"));

            Scene scene = new Scene(root);

            Stage primaryStage = new Stage();

            primaryStage.setTitle("Окно повторного входа");

            primaryStage.setScene(scene);

            primaryStage.initModality(Modality.WINDOW_MODAL);

            primaryStage.show();


        }


    }

}

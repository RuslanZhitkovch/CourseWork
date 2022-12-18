package com.example.coursework;



import java.io.IOException;
import java.net.Socket;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;

import com.example.coursework.Command;
import com.example.coursework.User;
import com.example.coursework.UserProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class adminPanelController
{
    private final ObservableList<UserProperty> tableUserProperties = FXCollections.observableArrayList();

    private ConnectionTCP connectionTCP;

    @FXML
    private Button button_add;

    @FXML
    private Button button_delete;

    @FXML
    private Button button_exit;

    @FXML
    private Button button_read;

    @FXML
    private Button button_update;

    @FXML
    private TableColumn<?, ?> column_access;

    @FXML
    private TableColumn<?, ?> column_age;

    @FXML
    private TableColumn<?, ?> column_id;

    @FXML
    private TableColumn<?, ?> column_job_title;

    @FXML
    private TableColumn<?, ?> column_name;

    @FXML
    private TableColumn<?, ?> column_password;

    @FXML
    private TableColumn<?, ?> column_role;

    @FXML
    private TableColumn<?, ?> column_second_name;

    @FXML
    private TableColumn<?, ?> email_column;

    @FXML
    private TextField field_access;

    @FXML
    private TextField field_age;

    @FXML
    private TextField field_email;

    @FXML
    private TextField field_job_title;

    @FXML
    private TextField field_name;

    @FXML
    private TextField field_password;

    @FXML
    private TextField field_role;

    @FXML
    private TextField field_second_name;

    @FXML
    private TableView<UserProperty> table;



    @FXML
    void initialize()
    {

        try
        {
            connectionTCP = new ConnectionTCP(new Socket("127.0.0.1", 8000));
        }
        catch (IOException e)
        {
            System.out.println("Ошибка в соединении");
            e.printStackTrace();
            System.exit(-1);
        }

        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_second_name.setCellValueFactory(new PropertyValueFactory<>("second_name"));
        email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
        column_age.setCellValueFactory(new PropertyValueFactory<>("code_date_of_birth"));
        column_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        column_access.setCellValueFactory(new PropertyValueFactory<>("access"));
        column_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        column_job_title.setCellValueFactory(new PropertyValueFactory<>("job_title"));
        column_id.setCellValueFactory(new PropertyValueFactory<>("idusers"));

        button_add.setOnAction(actionEvent -> {
            User user = new User(
                    field_name.getText().trim(),
                    field_second_name.getText().trim(),
                    field_email.getText().trim(),
                    field_age.getText().trim(),
                    field_job_title.getText().trim(),
                    field_role.getText().trim(),
                    field_access.getText().trim(),
                    field_password.getText().trim()

            );

            connectionTCP.writeObject(Command.CREATE);
            connectionTCP.writeObject(user);
        });

        button_read.setOnAction(actionEvent ->
        {
            tableUserProperties.clear();           // чтобы не добавлять каждый раз к существующему списку
            connectionTCP.writeObject(Command.READ);
            List<User> users = (List<User>) connectionTCP.readObject();
            for (User user : users) {
                UserProperty e = new UserProperty(user);
                tableUserProperties.add(e);
            }
            table.setItems(tableUserProperties);
        });



        button_update.setOnAction(actionEvent -> {
            if (table.getSelectionModel().getSelectedItem() != null) {
                field_name.setText(table.getSelectionModel().getSelectedItem().getName());
                field_second_name.setText(table.getSelectionModel().getSelectedItem().getSecond_name());
                field_email.setText(table.getSelectionModel().getSelectedItem().getEmail());
                field_age.setText(table.getSelectionModel().getSelectedItem().getAge());
                field_role.setText(table.getSelectionModel().getSelectedItem().getRole());
                field_access.setText(table.getSelectionModel().getSelectedItem().getAccess());
                field_password.setText(table.getSelectionModel().getSelectedItem().getPassword());
                field_job_title.setText(table.getSelectionModel().getSelectedItem().getJob_title());
            } else {
                field_name.setText("Выберите параметр для изменения");
            }
            button_update.setOnAction(e -> {
                User user = new User(
                        field_name.getText().trim(),
                        field_second_name.getText().trim(),
                        field_email.getText().trim(),
                        field_age.getText().trim(),
                        field_role.getText().trim(),
                        field_access.getText().trim(),
                        field_password.getText().trim(),
                        field_job_title.getText().trim(),


                        table.getSelectionModel().getSelectedItem().getIdusers()
                );
                connectionTCP.writeObject(Command.UPDATE);
                connectionTCP.writeObject(user);
            });
        });

        button_delete.setOnAction(actionEvent -> {
            Integer id = table.getSelectionModel().getSelectedItem().getIdusers();
            connectionTCP.writeObject(Command.DELETE);
            connectionTCP.writeObject(id);
        });

        button_exit.setOnAction(actionEvent -> {
            connectionTCP.writeObject(Command.EXIT);
            System.exit(0);
        });

    }
}


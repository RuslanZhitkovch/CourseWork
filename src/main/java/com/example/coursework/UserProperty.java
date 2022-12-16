package com.example.coursework;


import javafx.beans.property.*;



public class UserProperty
{
    private final SimpleIntegerProperty idusers;
    private final SimpleStringProperty name;
    private final SimpleStringProperty second_name;
    private final SimpleStringProperty email;
    private final SimpleStringProperty age;
    private final SimpleStringProperty job_title;
    private final SimpleStringProperty role;
    private final SimpleStringProperty access;
    private final SimpleStringProperty password;








    public Integer getIdusers() {
        return idusers.get();
    }

    public SimpleIntegerProperty idusersProperty() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers.set(idusers);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSecond_name() {
        return second_name.get();
    }

    public SimpleStringProperty second_nameProperty() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name.set(second_name);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getJob_title() {
        return job_title.get();
    }

    public SimpleStringProperty job_titleProperty() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title.set(job_title);
    }

    public String getRole() {
        return role.get();
    }

    public SimpleStringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public String getAccess() {
        return access.get();
    }

    public SimpleStringProperty accessProperty() {
        return access;
    }

    public void setAccess(String access) {
        this.access.set(access);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }



    public UserProperty(User user)
    {
        idusers = new SimpleIntegerProperty(user.getIdusers());
        name = new SimpleStringProperty(user.getName());
        second_name = new SimpleStringProperty(user.getSecond_name());
        email = new SimpleStringProperty(user.getEmail());
        age = new SimpleStringProperty(user.getAge());
        job_title = new SimpleStringProperty(user.getJob_title());
        role = new SimpleStringProperty(user.getRole());
        access = new SimpleStringProperty(user.getAccess());
        password = new SimpleStringProperty(user.getPassword());
    }














}

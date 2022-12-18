package com.example.coursework;

import java.io.Serializable;

public class User implements Serializable
{



    private Integer idusers;
    private String name;
    private String second_name;
    private String email;
    private String code_date_of_birth;
    private String job_title;
    private String role;
    public  String access;
    private String password;

    public User(Integer idusers, String name, String second_name, String email, String code_date_of_birth, String job_title, String role, String access, String password)
    {

        this.idusers = idusers;
        this.name = name;
        this.second_name = second_name;
        this.email = email;
        this.code_date_of_birth = code_date_of_birth;
        this.job_title = job_title;
        this.role = role;
        this.access = access;
        this.password = password;
    }

    public User(String name, String second_name, String email, String code_date_of_birth,  String role, String access, String password,String job_title)
    {
        this.name = name;
        this.second_name = second_name;
        this.email = email;
        this.code_date_of_birth = code_date_of_birth;
        this.job_title = job_title;
        this.role = role;
        this.access = access;
        this.password = password;
    }


    public User() {

    }

    public User(String name, String second_name, String email, String code_date_of_birth, String role ,String access, String password, String job_title,Integer idusers)
    {
        this.name = name;
        this.second_name = second_name;
        this.email = email;
        this.code_date_of_birth = code_date_of_birth;
        this.job_title = job_title;
        this.role = role;
        this.access = access;
        this.password = password;
        this.idusers = idusers;

    }




    public Integer getIdusers()
    {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return code_date_of_birth;
    }

    public void setAge(String code_date_of_birth) {
        this.code_date_of_birth = code_date_of_birth;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

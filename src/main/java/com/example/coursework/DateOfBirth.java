package com.example.coursework;

public class DateOfBirth
{
    private Integer idDateOfBirth;
    private Integer day;
    private String month;
    private String year;


    public DateOfBirth(Integer idDateOfBirth, Integer day, String month, String year) {
        this.idDateOfBirth = idDateOfBirth;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DateOfBirth( Integer day, String month, String year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }



    public DateOfBirth() {

    }

    public Integer getIdDateOfBirth() {
        return idDateOfBirth;
    }

    public void setIdDateOfBirth(Integer idDateOfBirth) {
        this.idDateOfBirth = idDateOfBirth;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

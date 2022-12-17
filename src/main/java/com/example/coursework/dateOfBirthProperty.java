package com.example.coursework;


import javafx.beans.property.*;

public class dateOfBirthProperty
{
    private final SimpleIntegerProperty idDateOfBirth;
    private final SimpleIntegerProperty day;
    private final SimpleStringProperty month;
    private final SimpleStringProperty year;



    public dateOfBirthProperty(DateOfBirth dateOfBirth)
    {
        idDateOfBirth = new SimpleIntegerProperty(dateOfBirth.getIdDateOfBirth());
        day = new SimpleIntegerProperty(dateOfBirth.getDay());
        month = new SimpleStringProperty(dateOfBirth.getMonth());
        year = new SimpleStringProperty(dateOfBirth.getYear());

    }






    public int getIdDateOfBirth() {
        return idDateOfBirth.get();
    }

    public SimpleIntegerProperty idDateOfBirthProperty() {
        return idDateOfBirth;
    }

    public void setIdDateOfBirth(int idDateOfBirth) {
        this.idDateOfBirth.set(idDateOfBirth);
    }

    public int getDay() {
        return day.get();
    }

    public SimpleIntegerProperty dayProperty() {
        return day;
    }

    public void setDay(int day) {
        this.day.set(day);
    }

    public String getMonth() {
        return month.get();
    }

    public SimpleStringProperty monthProperty() {
        return month;
    }

    public void setMonth(String month) {
        this.month.set(month);
    }

    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }



}

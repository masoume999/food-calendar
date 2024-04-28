package com.example.foodcalender.Domain;

public class Reminder {
    private String Name;
    private String Time;
    private String Date;

    public Reminder() {
    }

    public Reminder(String name, String time, String date) {
        Name = name;
        Time = time;
        Date = date;
    }


    public String getName() {
        return Name;
    }

    public String getTime() {
        return Time;
    }

    public String getDate() {
        return Date;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setDate(String date) {
        Date = date;
    }
}


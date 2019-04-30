package com.example.appproject;

import java.util.Locale;

public class lol {
    private String name;
    private String location;
    private int height;
    private String category;


    public lol (String inName, String inLocation, String inCategory, int inHeight) {
        name = inName;
        location = inLocation;
        height = inHeight;
        category = inCategory;

    }

    public lol (String inName) {
        name = inName;
        location = "";
        height = -1;
    }

    public String toString() {
        return name;
    }

    public String info() {
        String str = name;
        str += "\nHar attacktypen ";
        str += location;
        str += "\noch svårighetsgraden ";
        str += Integer.toString(height);
        str += "\nTyp av champion: ";
        str += category;

        return str;
    }

    public void setHeight (int newHeight){
        this.height = newHeight;
    }
    public String getHeight() {
        String hojd=String.valueOf(height);
        return hojd;
    }

    public void setLocation (String newLocation) {
        this.location = newLocation;

    }
    public String getLocation () {
        String newLocation = location;
        return newLocation;
    }

    public void setCategory (String newCategory) {
        this.category = newCategory;

    }
    public String getCategory () {
        String newCategory = category;
        return newCategory;
    }


}

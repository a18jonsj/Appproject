package com.example.appproject;

import java.util.Locale;

public class lol {
    private String name;
    private String location;
    private int height;
    private String category;
    private int cost;
    private String company;
    private String auxdata;


    public lol (String inName, String inLocation, String inCategory, String inCompany, String inAuxdata, int inHeight, int inCost) {
        name = inName;
        location = inLocation;
        height = inHeight;
        category = inCategory;
        cost = inCost;
        company = inCompany;
        auxdata = inAuxdata;


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
        str += "\nAttacktyp: ";
        str += location;
        str += "\nSvårighetsgrad: ";
        str += Integer.toString(height);
        str += "\nTyp: ";
        str += category;
        str += "\nPris: ";
        str += cost;
        str += "\nTyp av DMG: ";
        str += company;


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
    public String getAuxdata () {
        String newAuxdata = auxdata;
        return newAuxdata;
    }

    public void setAuxdata (String newAuxdata) {
        this.auxdata = newAuxdata;

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

    public void setCost (int newCost){
        this.cost = newCost;
    }
    public String getCost() {
        String pris=String.valueOf(cost);
        return pris;
    }

    public void setCompany (String newCompany) {
        this.company = newCompany;

    }
    public String getCompany () {
        String newCompany = company;
        return newCompany;
    }


}

package com.cbalt.firebaserecyclerview.models;

import java.io.Serializable;

public class Album implements Serializable {

    private String band, name, gender;

    public Album() {
    }

    public Album(String band, String name, String gender) {
        this.band = band;
        this.name = name;
        this.gender = gender;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

package com.example.micka.playgroundprojectv2.Models;

/**
 * Created by micka on 1/16/2018.
 */

public class Beacon {

    private String imgUrl;
    private String name;

    public Beacon(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

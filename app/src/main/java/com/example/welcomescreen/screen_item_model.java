package com.example.welcomescreen;

public class screen_item_model {

    String title, description;
    int screenImage;

    public screen_item_model(String title, String description, int screenImage) {
        this.title = title;
        this.description = description;
        this.screenImage = screenImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public int getScreenImage() {
        return screenImage;
    }

}

package com.coderYogyakarta.model_box_office;

public class SingleContentHomeModel {
    private String nameFilm, url, description;


    public SingleContentHomeModel(String nameFilm, String url) {
        this.nameFilm = nameFilm;
        this.url = url;

    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

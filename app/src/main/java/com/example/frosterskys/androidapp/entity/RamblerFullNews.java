package com.example.frosterskys.androidapp.entity;

/**
 * Created by evbe0615 on 10-Jan-18.
 */

public class RamblerFullNews {
    private String title;
    private String imageRef;
    private String article;
    private String source;
    private String time;

    public RamblerFullNews() {
    }

    public RamblerFullNews(String title, String imageRef, String article, String source, String time) {
        this.title = title;
        this.imageRef = imageRef;
        this.article = article;
        this.source = source;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

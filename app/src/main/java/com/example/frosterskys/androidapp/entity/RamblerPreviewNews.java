package com.example.frosterskys.androidapp.entity;

/**
 * Created by Frostersky's on 15.12.2017.
 */

public class RamblerPreviewNews {
    private String topic;
    private String imageLink;
    private String link;

    public RamblerPreviewNews(String topic, String imageLink, String link) {
        this.topic = topic;
        this.imageLink = imageLink;
        this.link = link;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

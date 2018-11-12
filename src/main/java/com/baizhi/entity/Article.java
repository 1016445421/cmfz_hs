package com.baizhi.entity;

import java.util.Date;

public class Article {
    private String id;
    private String title;
    private String imgPath;
    private String content;
    private Date publishDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Article(String id, String title, String imgPath, String content, Date publishDate) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.publishDate = publishDate;
    }

    public Article() {
    }
}

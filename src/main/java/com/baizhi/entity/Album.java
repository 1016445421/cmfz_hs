package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//专辑表
public class Album {
        private String id;
        private String title;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date publishDate;
        private Integer count;
        private String covering;
        private String star;
        private String author;
        private String broabcast;
        private String brief;
        private List<Chapter> children=new ArrayList<Chapter>();

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", count=" + count +
                ", covering='" + covering + '\'' +
                ", star='" + star + '\'' +
                ", author='" + author + '\'' +
                ", broabcast='" + broabcast + '\'' +
                ", brief='" + brief + '\'' +
                ", children=" + children +
                '}';
    }

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

    public Date getPublishDate(Date date) {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCovering() {
        return covering;
    }

    public void setCovering(String covering) {
        this.covering = covering;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroabcast() {
        return broabcast;
    }

    public void setBroabcast(String broabcast) {
        this.broabcast = broabcast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album(String id, String title, Date publishDate, Integer count, String covering, String star, String author, String broabcast, String brief, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.count = count;
        this.covering = covering;
        this.star = star;
        this.author = author;
        this.broabcast = broabcast;
        this.brief = brief;
        this.children = children;
    }

    public Album() {
    }
}

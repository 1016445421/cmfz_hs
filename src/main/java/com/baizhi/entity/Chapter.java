package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private String id;
    private String title;
    private String sizes;
    private String duration;
    private String downPath;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date upLoadTime;
    private String album_id;

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", sizes='" + sizes + '\'' +
                ", duration='" + duration + '\'' +
                ", downPath='" + downPath + '\'' +
                ", upLoadTime=" + upLoadTime +
                ", album_id='" + album_id + '\'' +
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

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    public Date getUpLoadTime() {
        return upLoadTime;
    }

    public void setUpLoadTime(Date upLoadTime) {
        this.upLoadTime = upLoadTime;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public Chapter(String id, String title, String sizes, String duration, String downPath, Date upLoadTime, String album_id) {
        this.id = id;
        this.title = title;
        this.sizes = sizes;
        this.duration = duration;
        this.downPath = downPath;
        this.upLoadTime = upLoadTime;
        this.album_id = album_id;
    }

    public Chapter() {
    }
}

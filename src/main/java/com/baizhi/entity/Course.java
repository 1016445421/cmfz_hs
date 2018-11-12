package com.baizhi.entity;

import java.util.Date;

public class Course {
    private Integer id;
    private String title;
    private String marking;
    private Date createTime;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", marking='" + marking + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Course(Integer id, String title, String marking, Date createTime) {
        this.id = id;
        this.title = title;
        this.marking = marking;
        this.createTime = createTime;
    }

    public Course() {
    }
}

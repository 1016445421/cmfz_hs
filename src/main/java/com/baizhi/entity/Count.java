package com.baizhi.entity;

import java.util.Date;

public class Count {
    private Integer id;
    private String title;
    private Integer count;
    private Date recordDate;
    private Integer user_id;
    private Integer course_id;

    @Override
    public String toString() {
        return "Count{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", recordDate=" + recordDate +
                ", user_id=" + user_id +
                ", course_id=" + course_id +
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Count(Integer id, String title, Integer count, Date recordDate, Integer user_id, Integer course_id) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.recordDate = recordDate;
        this.user_id = user_id;
        this.course_id = course_id;
    }

    public Count() {
    }
}

package com.baizhi.entity;

import java.util.Date;

public class User {
    private String id;
    private String phone;
    private String username;
    private String password;
    private String salt;
    private String province;
    private String city;
    private String nickname;
    private String gender;
    private String sign;
    private String headPic;
    private String status;
    private Date update;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", sign='" + sign + '\'' +
                ", headPic='" + headPic + '\'' +
                ", status='" + status + '\'' +
                ", update=" + update +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public User(String id, String phone, String username, String password, String salt, String province, String city, String nickname, String gender, String sign, String headPic, String status, Date update) {
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.province = province;
        this.city = city;
        this.nickname = nickname;
        this.gender = gender;
        this.sign = sign;
        this.headPic = headPic;
        this.status = status;
        this.update = update;
    }

    public User() {
    }
}

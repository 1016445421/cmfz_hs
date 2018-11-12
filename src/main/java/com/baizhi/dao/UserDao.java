package com.baizhi.dao;
import com.baizhi.entity.User;

public interface UserDao {
    void insert(User user);
    User queryAll(User user);
    void update(User user);
}

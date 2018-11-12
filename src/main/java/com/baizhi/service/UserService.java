package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    void add(User user);
    User login(User user);
    void update(User user);
}

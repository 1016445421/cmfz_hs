package com.baizhi.service;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
private UserDao userDao;

    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
       userDao.insert(user);
    }

    @Override
    public User login(User user) {
        User logins = userDao.queryAll(user);
        if(logins!=null){
            return logins;
        }else{
            return null;
        }
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}

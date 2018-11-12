package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public void update(Admin adm) {
        adminDao.update(adm);
    }

    @Override
    public Admin login(Admin adm) {
        Admin login = adminDao.login(adm);
        if(login!=null){
            return login;
        }
        return null;
        }

    }

package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService{

    @Autowired
    private BannerDao bannerDao;

    @Override
    public void remove(int id) {
        bannerDao.delete(id);
    }

    @Override
    public void add(Banner banner) {
        bannerDao.insert(banner);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Banner findOne(int id) {
        return bannerDao.queryOne(id);
    }

    @Override
    public void motify(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public List<Banner> findAll() {
        List<Banner> list = bannerDao.queryAll();
        return list;
    }
}

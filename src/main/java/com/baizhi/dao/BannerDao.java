package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerDao {
    List<Banner> queryAll();
    void insert(Banner banner);
    void update(Banner banner);

    Banner queryOne(int id);
    void delete(int id);


}

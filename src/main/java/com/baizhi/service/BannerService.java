package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> findAll();
    void motify(Banner banner);
    Banner findOne(int id);
    void remove(int id);

    void add(Banner banner);
}

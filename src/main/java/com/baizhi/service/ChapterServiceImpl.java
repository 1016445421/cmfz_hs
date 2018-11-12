package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{

    @Autowired
    private ChapterDao chapterDao;

   /* @Override
    public Chapter findOne(int id) {
        return null;
    }*/

    @Override
    public void add(Chapter chapter) {
        chapterDao.insert(chapter);
    }


    @Override
    public List<Chapter> findAll() {
        List<Chapter> list = chapterDao.showAll();
        return list;
    }
}

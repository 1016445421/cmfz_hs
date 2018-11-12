package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> findAll();
   /* Chapter findOne(int id);*/

    void add(Chapter chapter);
}

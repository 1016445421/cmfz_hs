package com.baizhi.dao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterDao {
    List<Chapter> showAll();
    void insert(Chapter chapter);

    /*void delete(int id);*/




}

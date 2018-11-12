package com.baizhi.dao;

import com.baizhi.entity.Album;
import java.util.List;

public interface AlbumDao {
    List<Album> queryAll();
    void insert(Album album);
    Album queryOne(String id);




}

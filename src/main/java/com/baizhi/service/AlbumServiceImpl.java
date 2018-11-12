package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumDao albumDao;

    @Override
    public void add(Album album) {
        albumDao.insert(album);
    }


     @Override
     @Transactional(propagation = Propagation.SUPPORTS)
     public Album findOne(String id) {
         return albumDao.queryOne(id);
     }

    @Override
    public List<Album> findAll() {
        List<Album> list = albumDao.queryAll();
        for (Album album : list){
        }
        return list;
    }
}

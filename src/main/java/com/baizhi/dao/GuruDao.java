package com.baizhi.dao;
import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruDao {
    List<Guru> queryAll();
    void insert(Guru guru);
    void update(Guru guru);

    Guru queryOne(String id);
    void delete(String id);
}

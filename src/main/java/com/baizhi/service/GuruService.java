package com.baizhi.service;
import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    List<Guru> findAll();
    void motify(Guru guru);
    Guru findOne(String id);
    void remove(String id);

    void add(Guru guru);
}

package com.example.secondhand_springboot.service;

import com.example.secondhand_springboot.controller.request.CategorizePageRequest;
import com.example.secondhand_springboot.entity.Categorize;

public interface ICategorizeService {
    Object page(CategorizePageRequest categorizePageRequest);
    void  deleteById(Integer id);

    void   save(Categorize categorize);

    Categorize getById(Integer id);
    void update(Categorize categorize);
}

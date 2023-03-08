package com.example.secondhand_springboot.service;

import com.example.secondhand_springboot.controller.request.GoodsPageRequest;
import com.example.secondhand_springboot.controller.request.UsersPageRequest;
import com.example.secondhand_springboot.entity.Goods;

public interface IGoodsService {
    Object page(GoodsPageRequest goodsPageRequest);
    void  deleteById(Integer id);

    void shop(Goods goods);
}

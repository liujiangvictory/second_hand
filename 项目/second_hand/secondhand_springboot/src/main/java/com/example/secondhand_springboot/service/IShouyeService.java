package com.example.secondhand_springboot.service;

import com.example.secondhand_springboot.controller.request.ShouyePageRequest;
import com.example.secondhand_springboot.entity.Collects;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.entity.Orders;
import com.example.secondhand_springboot.entity.Shouye;

import java.util.List;

public interface IShouyeService {
    Object listByNameGoods_page(ShouyePageRequest shouyePageRequest);

    Object categorize_page(ShouyePageRequest shouyePageRequest);
    Object listByNameCategorize_page( ShouyePageRequest shouyePageRequest);

    Goods listDetail(Integer id);

    void  addCollect(Collects collects);
    int  isCollects(Integer g_id,Integer login_id);
    void  delCollect(Integer g_id);

    void  addShopping(Orders orders);

    Orders shoppingById();
}

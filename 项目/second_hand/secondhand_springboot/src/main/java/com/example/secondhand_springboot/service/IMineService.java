package com.example.secondhand_springboot.service;

import com.example.secondhand_springboot.entity.Collects;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.entity.Orders;
import com.example.secondhand_springboot.entity.Users;

import java.util.List;

public interface IMineService {
    Users getByName(Integer u_id);

    Users getMessageId(Integer u_id);
    void update(Users users);

    List<Collects> collects_list(Integer u_id);

    List<Goods> goods_list(Integer u_id);

    Goods getGoodsId(Integer g_id);
    void updateByGoodsId(Goods goods);

    void  deleteByGoodsId(Integer g_id);

    List<Orders> orders_list(Integer u_id);

    Orders getOrders(Integer o_id);

    void deleteOrders(Integer o_id);

    void updateOrders(Orders orders);
}

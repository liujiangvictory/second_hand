package com.example.secondhand_springboot.mapper;

import com.example.secondhand_springboot.entity.Collects;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.entity.Orders;
import com.example.secondhand_springboot.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MineMapper {
    Users getByName(Integer u_id);
//     修改个人信息
    Users getMessageId(Integer u_id);
    Users MessageAll(String email);
    void updateById(Users users);

    List<Collects> collects_list(Integer u_id);

    List<Goods> goods_list(Integer u_id);

//    修改物品信息
    Goods getGoodsId(Integer g_id);
    void updateByGoodsId(Goods goods);

//    删除物品信息
     void  deleteByGoodsId(Integer g_id);

    List<Orders> orders_list(Integer u_id);

    Orders getOrders(Integer o_id);

    void deleteOrders(Integer o_id);

    void updateOrders(Orders orders);
}

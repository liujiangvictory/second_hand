package com.example.secondhand_springboot.mapper;

import com.example.secondhand_springboot.controller.request.ShouyePageRequest;
import com.example.secondhand_springboot.entity.Collects;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.entity.Orders;
import com.example.secondhand_springboot.entity.Shouye;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShouyeMapper {
    List<Goods> listByNameGoods(ShouyePageRequest shouyePageRequest);

    List<Goods> listByCategorize(ShouyePageRequest shouyePageRequest);
//    点击类别跳转的分页
    List<Goods> listByNameCategorize(ShouyePageRequest shouyePageRequest);

    Goods listDetail(Integer id);


    void  addCollect(Collects collects);
   Collects  isCollects(Integer g_id,Integer login_id);
    void    delCollect(Integer g_id);

    void  addShopping(Orders orders);

    Orders shoppingById();
}

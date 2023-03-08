package com.example.secondhand_springboot.service.impl;

import com.example.secondhand_springboot.controller.request.ShouyePageRequest;
import com.example.secondhand_springboot.entity.Collects;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.entity.Orders;
import com.example.secondhand_springboot.entity.Shouye;
import com.example.secondhand_springboot.mapper.ShouyeMapper;
import com.example.secondhand_springboot.service.IShouyeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShouyeService implements IShouyeService {
    @Autowired
    ShouyeMapper shouyeMapper;

    @Override
    public Object listByNameGoods_page(ShouyePageRequest shouyePageRequest) {
        PageHelper.startPage(shouyePageRequest.getPageNum(),shouyePageRequest.getPageSize());
        List<Goods> goods=shouyeMapper.listByNameGoods(shouyePageRequest);
        return new PageInfo<>(goods);
    }

    @Override
    public Object categorize_page(ShouyePageRequest shouyePageRequest) {
        PageHelper.startPage(shouyePageRequest.getPageNum(),shouyePageRequest.getPageSize());
        List<Goods> categorize=shouyeMapper.listByCategorize(shouyePageRequest);
        return new PageInfo<>(categorize);
    }
    @Override
    public Object listByNameCategorize_page(ShouyePageRequest shouyePageRequest) {
        PageHelper.startPage(shouyePageRequest.getPageNum(),shouyePageRequest.getPageSize());
        List<Goods> categorize=shouyeMapper.listByNameCategorize(shouyePageRequest);
        return new PageInfo<>(categorize);
//        return shouyeMapper.listByNameCategorize(shouyePageRequest);
    }

    @Override
    public Goods listDetail(Integer id) {
        return shouyeMapper.listDetail(id);
    }

    @Override
    public void addCollect(Collects collects) {
        shouyeMapper.addCollect(collects);
    }

    @Override
    public int isCollects(Integer g_id,Integer login_id) {
//        int   shouyeMapper.isCollects(g_id,login_id);
        if(shouyeMapper.isCollects(g_id,login_id)!=null){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public void delCollect(Integer g_id) {
       shouyeMapper.delCollect(g_id);
    }

    @Override
    public void addShopping(Orders orders) {
        orders.setPost_time(new Date());
        orders.setO_state("交易中");
        shouyeMapper.addShopping(orders);
    }

    @Override
    public Orders shoppingById() {
        return shouyeMapper.shoppingById();
    }


}

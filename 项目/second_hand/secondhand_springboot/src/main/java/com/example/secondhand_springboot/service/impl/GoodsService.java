package com.example.secondhand_springboot.service.impl;

import com.example.secondhand_springboot.controller.request.GoodsPageRequest;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.mapper.GoodsMapper;
import com.example.secondhand_springboot.service.IGoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService implements IGoodsService {
      @Autowired
    GoodsMapper goodsMapper;
    @Override
    public Object page(GoodsPageRequest goodsPageRequest) {
        PageHelper.startPage(goodsPageRequest.getPageNum(),goodsPageRequest.getPageSize());
        List<Goods> goods=goodsMapper.listByCondition(goodsPageRequest);
        return new PageInfo<>(goods);
    }

    @Override
    public void deleteById(Integer id) {
        goodsMapper.deleteById(id);
    }

    @Override
    public void shop(Goods goods) {
        goodsMapper.shop(goods);
    }
}

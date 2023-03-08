package com.example.secondhand_springboot.mapper;

import com.example.secondhand_springboot.controller.request.GoodsPageRequest;
import com.example.secondhand_springboot.controller.request.UsersPageRequest;
import com.example.secondhand_springboot.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> listByCondition(GoodsPageRequest goodsPageRequest);

    void deleteById(Integer id);

    void shop(Goods goods);
}

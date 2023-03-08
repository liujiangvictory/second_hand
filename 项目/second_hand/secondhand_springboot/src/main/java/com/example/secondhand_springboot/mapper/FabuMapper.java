package com.example.secondhand_springboot.mapper;

import com.example.secondhand_springboot.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FabuMapper {
    void  save(Goods goods);
}

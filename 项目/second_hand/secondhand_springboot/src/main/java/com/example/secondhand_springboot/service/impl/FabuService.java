package com.example.secondhand_springboot.service.impl;

import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.mapper.FabuMapper;
import com.example.secondhand_springboot.service.IFabuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FabuService implements IFabuService {
    @Autowired
    FabuMapper fabuMapper;

    @Override
    public void save(Goods goods) {
        goods.setG_state("在售");
        goods.setSub_time(new Date());
        fabuMapper.save(goods);
    }
}

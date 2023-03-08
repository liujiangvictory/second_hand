package com.example.secondhand_springboot.service.impl;

import com.example.secondhand_springboot.controller.request.OrdersPageRequest;
import com.example.secondhand_springboot.entity.Orders;
import com.example.secondhand_springboot.mapper.OrdersMapper;
import com.example.secondhand_springboot.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService {
    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public Object page(OrdersPageRequest ordersPageRequest) {
        PageHelper.startPage(ordersPageRequest.getPageNum(),ordersPageRequest.getPageSize());
        List<Orders> users=ordersMapper.listByCondition(ordersPageRequest);
        return new PageInfo<>(users);
    }

    @Override
    public void deleteById(Integer id) {
        ordersMapper.deleteById(id);
    }
}

package com.example.secondhand_springboot.mapper;

import com.example.secondhand_springboot.controller.request.OrdersPageRequest;
import com.example.secondhand_springboot.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    List<Orders> listByCondition(OrdersPageRequest ordersPageRequest);
    void deleteById(Integer id);
}

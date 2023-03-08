package com.example.secondhand_springboot.service;

import com.example.secondhand_springboot.controller.request.OrdersPageRequest;

public interface IOrdersService {
    Object page(OrdersPageRequest ordersPageRequest);
    void  deleteById(Integer id);
}

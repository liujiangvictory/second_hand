package com.example.secondhand_springboot.controller;

import com.example.secondhand_springboot.common.Result;
import com.example.secondhand_springboot.controller.request.OrdersPageRequest;
import com.example.secondhand_springboot.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    IOrdersService ordersService;
    @GetMapping("/page")
    public Result page(OrdersPageRequest ordersPageRequest){
        return Result.success(ordersService.page(ordersPageRequest));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
         ordersService.deleteById(id);
        return Result.success();
    }
}

package com.example.secondhand_springboot.controller;

import com.example.secondhand_springboot.common.Result;
import com.example.secondhand_springboot.controller.request.GoodsPageRequest;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    IGoodsService goodsService;
    @GetMapping("/page")
    public Result page(GoodsPageRequest goodsPageRequest){
        return Result.success(goodsService.page(goodsPageRequest));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        goodsService.deleteById(id);
        return Result.success();
    }
    @PutMapping("/shop")
    public Result shop(@RequestBody Goods goods){
        goodsService.shop(goods);
        return Result.success();
    }

}

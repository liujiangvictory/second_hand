package com.example.secondhand_springboot.controller;

import com.example.secondhand_springboot.common.Result;
import com.example.secondhand_springboot.controller.request.ShouyePageRequest;
import com.example.secondhand_springboot.entity.Collects;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.entity.Orders;
import com.example.secondhand_springboot.entity.Shouye;
import com.example.secondhand_springboot.service.IGoodsService;
import com.example.secondhand_springboot.service.IShouyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//跨域
@CrossOrigin
@RestController
@RequestMapping("/shouye")
public class ShouyeController {
    @Autowired
    IShouyeService shouyeService;
    @GetMapping("/listByNameGoods_page")
    public Result listByNameGoods_page(ShouyePageRequest shouyePageRequest){
        return Result.success(shouyeService.listByNameGoods_page(shouyePageRequest));
    }

    @GetMapping("/categorize")
    public Result categorize_page(ShouyePageRequest shouyePageRequest){
        return Result.success(shouyeService.categorize_page(shouyePageRequest));
    }
    @GetMapping("/categorizeList") //@PathVariable String c_name,
    public Result listByNameCategorize_page(ShouyePageRequest shouyePageRequest){
//        List<Goods> users=;
        return Result.success(shouyeService.listByNameCategorize_page(shouyePageRequest));
    }

    @GetMapping("/detail/{id}")
    public Result getById(@PathVariable Integer id){
        Goods users=shouyeService.listDetail(id);
        return Result.success(users);
    }


    @PostMapping("/addCollect")
    public Result addCollect(@RequestBody Collects collects){
        shouyeService.addCollect(collects);
        return Result.success();
    }
    @GetMapping("/isCollects/{g_id}&{login_id}")
    public Result isCollects(@PathVariable Integer g_id,@PathVariable Integer login_id){
        int collects=shouyeService.isCollects(g_id,login_id);
        return Result.success(collects);
    }
    @DeleteMapping("/delCollect/{g_id}")
    public Result delete(@PathVariable Integer g_id){
        shouyeService.delCollect(g_id);
        return Result.success();
    }

    @PostMapping("/shopping")
    public Result addShopping(@RequestBody Orders orders){
        shouyeService.addShopping(orders);
        return Result.success();
    }

//    点击购买查看详情
    @GetMapping("/detail/shopping_id")
    public Result shoppingById(){
        Orders orders=shouyeService.shoppingById();
        return Result.success(orders);
    }
}

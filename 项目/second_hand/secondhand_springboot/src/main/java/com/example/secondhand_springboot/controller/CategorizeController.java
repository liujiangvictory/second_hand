package com.example.secondhand_springboot.controller;

import com.example.secondhand_springboot.common.Result;
import com.example.secondhand_springboot.controller.request.CategorizePageRequest;
import com.example.secondhand_springboot.entity.Categorize;
import com.example.secondhand_springboot.service.ICategorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/categorize")
public class CategorizeController {
    @Autowired
    ICategorizeService categorizeService;

    @GetMapping("/page")
    public Result page(CategorizePageRequest categorizePageRequest){
        return Result.success(categorizeService.page(categorizePageRequest));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        categorizeService.deleteById(id);
        return Result.success();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Categorize categorize){
        categorizeService.save(categorize);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Categorize users=categorizeService.getById(id);
        return Result.success(users);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Categorize categorize){
        categorizeService.update(categorize);
        return Result.success();
    }
}

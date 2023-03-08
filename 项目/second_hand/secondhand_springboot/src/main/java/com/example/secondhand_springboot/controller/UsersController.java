package com.example.secondhand_springboot.controller;

import com.example.secondhand_springboot.common.Result;
import com.example.secondhand_springboot.controller.request.UsersPageRequest;
import com.example.secondhand_springboot.entity.Users;
import com.example.secondhand_springboot.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//跨域
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    IUsersService usersService;

      @GetMapping("/list")
    public Result list(){
         List<Users> users=usersService.list();
         return Result.success(users);
      }
      @GetMapping("/page")
      public Result page(UsersPageRequest usersPageRequest){
          return Result.success(usersService.page(usersPageRequest));
      }

      @PostMapping("/save")
    public Result save(@RequestBody Users users){
          usersService.save(users);
          return Result.success();
      }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Users users=usersService.getById(id);
        return Result.success(users);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Users users){
        usersService.update(users);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        usersService.deleteById(id);
        return Result.success();
    }
}

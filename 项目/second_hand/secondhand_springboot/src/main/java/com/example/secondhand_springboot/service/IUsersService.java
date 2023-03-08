package com.example.secondhand_springboot.service;

import com.example.secondhand_springboot.controller.request.UsersPageRequest;
import com.example.secondhand_springboot.entity.Users;

import java.util.List;

public interface IUsersService {
    List<Users> list();
    Object page(UsersPageRequest usersPageRequest);

    void  save(Users users);

    Users getById(Integer id);
    void update(Users users);

    void  deleteById(Integer id);
}

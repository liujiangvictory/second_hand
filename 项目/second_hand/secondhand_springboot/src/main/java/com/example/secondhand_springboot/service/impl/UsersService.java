package com.example.secondhand_springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.secondhand_springboot.controller.request.UsersPageRequest;
import com.example.secondhand_springboot.entity.Users;
import com.example.secondhand_springboot.mapper.UsersMapper;
import com.example.secondhand_springboot.service.IUsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsersService implements IUsersService {
    @Autowired
    UsersMapper usersMapper;

    @Override
    public List<Users> list() {
        return usersMapper.list();
    }

    @Override
    public Object page(UsersPageRequest usersPageRequest) {
        PageHelper.startPage(usersPageRequest.getPageNum(),usersPageRequest.getPageSize());
        List<Users> users=usersMapper.listByCondition(usersPageRequest);
        return new PageInfo<>(users);

    }

    @Override
    public void save(Users users) {
//        Date date=new Date();
//        users.setTel(DateUtil.format(date,"yyyyMMdd")+ Math.abs(IdUtil.fastSimpleUUID()));
        usersMapper.save(users);
    }

    @Override
    public Users getById(Integer id) {
        return usersMapper.getById(id);
    }

    @Override
    public void update(Users users) {
        users.setCreate_time(new Date());
        usersMapper.updateById(users);
    }

    @Override
    public void deleteById(Integer id) {
        usersMapper.deleteById(id);
    }


}

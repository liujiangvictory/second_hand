package com.example.secondhand_springboot.mapper;

import com.example.secondhand_springboot.controller.request.UsersPageRequest;
import com.example.secondhand_springboot.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {
//    @Select("select * from users")
    List<Users> list();

    List<Users> listByCondition(UsersPageRequest usersPageRequest);

    void  save(Users users);

    Users getById(Integer id);
    void updateById(Users users);

    void deleteById(Integer id);

}

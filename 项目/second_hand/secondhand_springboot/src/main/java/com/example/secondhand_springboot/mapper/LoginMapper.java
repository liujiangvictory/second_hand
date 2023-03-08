package com.example.secondhand_springboot.mapper;

import com.example.secondhand_springboot.controller.request.LoginRequest;
import com.example.secondhand_springboot.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

   Login getId(Integer u_id);

   Login getEmailAndPassword(LoginRequest loginRequest);

   Login getById(Integer id);

   Login getByEmail(String email);

   Login  registerAll(String email);
   void  register(Login login);
   Login getEmail(String email);

   Login getByUsername(String u_name);

   int upAvatarById(@Param("avatar") String avatar, @Param("u_id") int u_id);
}

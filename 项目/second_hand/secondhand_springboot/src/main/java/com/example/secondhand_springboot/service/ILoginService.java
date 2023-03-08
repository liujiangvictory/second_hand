package com.example.secondhand_springboot.service;

import com.example.secondhand_springboot.controller.dto.LoginDTO;
import com.example.secondhand_springboot.controller.request.LoginRequest;
import com.example.secondhand_springboot.entity.Login;

public interface ILoginService {

    Login getId(Integer u_id);

    LoginDTO login(LoginRequest loginRequest);

   Login getById(Integer id);

    void  register(Login login);

    Login getByUserName(String u_name);
    int upAvatarById(Login login);

}

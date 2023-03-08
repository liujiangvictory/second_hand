package com.example.secondhand_springboot.service.impl;

import com.example.secondhand_springboot.controller.dto.LoginDTO;
import com.example.secondhand_springboot.controller.request.LoginRequest;
import com.example.secondhand_springboot.entity.Login;
import com.example.secondhand_springboot.exception.ServiceException;
import com.example.secondhand_springboot.mapper.LoginMapper;
import com.example.secondhand_springboot.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class LoginService implements ILoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public Login getId(Integer u_id) {
        return loginMapper.getId(u_id);
    }

    public LoginDTO login(LoginRequest loginRequest) {
            loginMapper.getByEmail(loginRequest.getEmail());
            Login byemail=null;
            try{
                byemail=loginMapper.getEmail(loginRequest.getEmail());
            }catch (Exception e){
                log.error("根据邮箱名查询出错",loginRequest.getEmail());
                throw new ServiceException("邮箱错误");
            }


            Login login= loginMapper.getEmailAndPassword(loginRequest);
            if(login==null){
                throw new ServiceException("用户名或密码错误");
            }
            if(!login.isU_state()){
                throw  new ServiceException("当前用户处于禁用状态，请联系管理员");
            }

            LoginDTO loginDTO=new LoginDTO();
            BeanUtils.copyProperties(login,loginDTO);//只复制名字相同的属性

            return loginDTO;

    }


    @Override
    public Login getById(Integer id) {
        return loginMapper.getById(id);
    }

    @Override
    public void register(Login login) {
        Login  l=loginMapper.registerAll(login.getEmail());
        if(l!=null){
                if (l.getEmail().equals(login.getEmail())) {
                    throw new ServiceException("邮箱已存在，请重新输入！");
                }
        }else{
            login.setCreate_time(new Date());
            loginMapper.register(login);
        }
    }

    @Override
    public Login getByUserName(String u_name) {
        return loginMapper.getByUsername(u_name);
    }

    @Override
    public int upAvatarById(Login login) {
        int i=loginMapper.upAvatarById(login.getAvatar(),login.getU_id());
        if(i<0){
            throw new ServiceException("修改头像失败");
        }
        return i;
    }
}

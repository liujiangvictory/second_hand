package com.example.secondhand_springboot.controller.dto;

import lombok.Data;

@Data
public class LoginDTO {
//    返回数据
    private Integer u_id;
    private String u_name;
    private String tel;
    private String email;
    private boolean u_state;
    private  String  avatar;

}

package com.example.secondhand_springboot.controller.request;

import lombok.Data;

@Data
public class UsersPageRequest extends BaseRequest {
    //查询类
    private String u_name;
    private String u_state;

}

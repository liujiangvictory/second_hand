package com.example.secondhand_springboot.controller.request;

import lombok.Data;

@Data
public class ShouyePageRequest extends BaseRequest{
    private  String g_name;
    private Integer c_id;
}

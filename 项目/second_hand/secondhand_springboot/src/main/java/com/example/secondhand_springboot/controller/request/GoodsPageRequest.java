package com.example.secondhand_springboot.controller.request;

import lombok.Data;

@Data
public class GoodsPageRequest extends  BaseRequest{
    private String g_name;
    private String g_state;
}

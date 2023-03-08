package com.example.secondhand_springboot.controller.request;

import lombok.Data;

@Data
public class OrdersPageRequest  extends  BaseRequest {
    private String u_name;
    private String g_name;
    private String o_state;
}

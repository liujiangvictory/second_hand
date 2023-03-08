package com.example.secondhand_springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    private Integer o_id;
    private Integer g_id;
    private Integer login_id;
    private String u_name;
    private String g_name;
    private  float price;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
    private Date post_time;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
    private Date end_time;
    private String o_state;

}

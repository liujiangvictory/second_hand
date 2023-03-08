package com.example.secondhand_springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Goods {
    private Integer g_id;
    private  Integer c_id;
    private String c_name;
    private String g_name;
    private float price;
    private String u_name;
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date sub_time;
    private String g_state;
    private  String image;
    private String describe;
    private  Integer login_id;


}

package com.example.secondhand_springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Shouye {
    private Integer g_id;
    private  String g_name;
    private float price;
    private  Integer count;
    private  String remark;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date sub_time;
    private  String g_state;
    private  String image;
    private  String describe;
    private  String posted;
    private  Integer c_id;
    private String c_name;
}

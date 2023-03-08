package com.example.secondhand_springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Collects {
    private  Integer col_id;
    private  Integer c_id;
    private  Integer g_id;
    private  Integer login_id;
    private  String g_name;
    private  float price;
    private String c_name;
    private String u_name;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date sub_time;
    private boolean iscollects;

}

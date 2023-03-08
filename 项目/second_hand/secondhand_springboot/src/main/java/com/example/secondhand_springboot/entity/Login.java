package com.example.secondhand_springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Login {
    private Integer u_id;
    private String u_name;
    private String tel;
    private String email;
    private String sex;
    private  String password;
    private  String password1;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date create_time;
    private boolean u_state;
    private String avatar;

}

package com.example.secondhand_springboot.exception;

public class ServiceException  extends  RuntimeException{

//    错误信息暴露出去
    public ServiceException(String message) {
        super(message);
    }


}

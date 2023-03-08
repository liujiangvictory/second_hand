package com.example.secondhand_springboot.exception;

import cn.hutool.core.util.StrUtil;
import com.example.secondhand_springboot.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value=ServiceException.class)
    public Result ServiceExceptionError(ServiceException e){
        log.error("业务错误",e);

        return Result.error(e.getMessage());
    }

    @ExceptionHandler(value=Exception.class)
    public Result exceptionError(Exception e){
        log.error("系统错误",e);
        return Result.error("系统错误");
    }
}

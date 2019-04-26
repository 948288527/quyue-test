package com.quyue.handle;

import com.quyue.domain.Result;
import com.quyue.exception.RegistryException;
import com.quyue.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 廖师兄
 * 2017-01-21 13:59
 */
@ControllerAdvice
public class RegistryExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(RegistryExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof RegistryException) {
            RegistryException rgistryException = (RegistryException) e;
            return ResultUtil.error(rgistryException.getCode(), rgistryException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}

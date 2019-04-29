package com.quyue.controller;

import com.quyue.domain.Registry;
import com.quyue.domain.Result;
import com.quyue.repository.LoginRepository;
import com.quyue.repository.RegistryRepository;
import com.quyue.service.LoginService;
import com.quyue.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 廖师兄
 * 2016-11-03 23:15
 */
@CrossOrigin(origins = "*")  // @CrossOrigin(origins = {"http://localhost:9000", "null"}) 配置请求源解决跨域问题
@RestController
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private RegistryRepository registryRepository;

    @Autowired
    private LoginService loginService;
    @GetMapping(value = "/login")
    public List<Registry> registryList() {
        logger.info("registryList");

        return registryRepository.findAll();
    }
    // 根据用户名查询
    @GetMapping(value = "/login/phone/{phone}")
    public Result<Registry> registryListByAge(@PathVariable("phone") String phone) {
        return ResultUtil.success(registryRepository.findByphone(phone));
        // return registryRepository.findByphone(phone);
    }
}

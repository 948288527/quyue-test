package com.quyue.controller;

import com.quyue.domain.Registry;
import com.quyue.domain.Result;
import com.quyue.repository.RegistryRepository;
import com.quyue.service.RegistryService;
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
@RestController
public class QuyueRegistryController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private RegistryRepository registryRepository;

    @Autowired
    private RegistryService registryService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/registrys")
    public List<Registry> registryList() {
        logger.info("registryList");

        return registryRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/registrys")
    public Result<Registry> girlAdd(@Valid Registry registry, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        registry.setPhone(registry.getPhone());
        registry.setPassword(registry.getPassword());

        return ResultUtil.success(registryRepository.save(registry));
    }

    //查询一个女生
    @GetMapping(value = "/registrys/{phone}")
    public Registry registryFindOne(@PathVariable("id") String phone) {
        return registryRepository.findOne(phone);
    }

    //更新
    @PutMapping(value = "/registrys/{id}")
    public Registry registryUpdate(@PathVariable("id") Integer id,
                           @RequestParam("phone") String phone,
                           @RequestParam("password") String password) {
        Registry registry = new Registry();
        registry.setId(id);
        registry.setPhone(phone);
        registry.setPassword(password);

        return registryRepository.save(registry);
    }

    //删除
    @DeleteMapping(value = "/registrys/{phone}")
    public void registryDelete(@PathVariable("phone") String phone) {
        registryRepository.delete(phone);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/registrys/phone/{phone}")
    public List<Registry> registryListByAge(@PathVariable("phone") String phone) {
        return registryRepository.findByphone(phone);
    }

    @PostMapping(value = "/registrys/two")
    public void registryTwo() {
        registryService.insertTwo();
    }

    @GetMapping(value = "registrys/getPhone/{phone}")
    public void getPhone(@PathVariable("phone") String phone) throws Exception{
        registryService.getPhone(phone);
    }
}

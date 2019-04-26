package com.quyue.service;

import com.quyue.domain.Registry;
import com.quyue.enums.ResultEnum;
import com.quyue.exception.RegistryException;
import com.quyue.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 廖师兄
 * 2016-11-04 00:08
 */
@Service
public class RegistryService {

    @Autowired
    private RegistryRepository registryRepository;

    @Transactional
    public void insertTwo() {
        Registry personA = new Registry();
        personA.setPhone("13616533616");
        personA.setPassword("11111");
        registryRepository.save(personA);


        Registry personB = new Registry();
        personB.setPhone("123455678901");
        personB.setPassword("1231456");
        registryRepository.save(personB);
    }

    public void getPhone(String phone) throws Exception{
        Registry registry = registryRepository.findOne(phone);
       // String phone = registry.getPhone();
        if (phone.length() < 11) {
            //返回"你还在上小学吧" code=100
            throw new RegistryException(ResultEnum.PRIMARY_SCHOOL);
        }else if (phone.length() > 11) {
            //返回"你可能在上初中" code=101
            throw new RegistryException(ResultEnum.MIDDLE_SCHOOL);
        }

        //如果>16岁,加钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     * @param phone
     * @return
     */
    public Registry findOne(String phone) {
        return registryRepository.findOne(phone);
    }
}

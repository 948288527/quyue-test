package com.quyue.repository;

import com.quyue.domain.Registry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 廖师兄
 * 2016-11-03 23:17
 */
public interface LoginRepository extends JpaRepository<Registry, String> {

    //通过用户id来查询
    public List<Registry> findByphone(String Phone);
}

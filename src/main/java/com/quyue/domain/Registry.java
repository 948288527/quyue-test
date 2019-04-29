package com.quyue.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by 廖师兄
 * 2016-11-03 23:07
 */
@Entity
public class Registry {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "手机号必填")
    private String phone;

    @NotNull(message = "密码必填")
    private String password;

    @NotNull(message = "验证码必填")
    private String verificode;
    public Registry() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificode() {
        return verificode;
    }

    public void setVerificode(String verificode) {
        this.verificode = verificode;
    }

    @Override
    public String toString() {
        return "Registry{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password=" + password +
                ", verificode=" + verificode +
                '}';
    }
}

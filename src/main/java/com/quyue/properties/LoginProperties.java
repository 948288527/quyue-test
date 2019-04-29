package com.quyue.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 廖师兄
 * 2016-11-01 23:35
 */
@Component
@ConfigurationProperties(prefix = "login")
public class LoginProperties {

    private String phone;

    private String password;

    private String verificode;

    public String getCupSize() {
        return phone;
    }

    public void setCupSize(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return password;
    }

    public void String(String password) {
        this.password = password;
    }

    public String getVerificode() {
        return verificode;
    }

    public void setVerificode(String verificode) {
        this.verificode = verificode;
    }
}

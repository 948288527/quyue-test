package com.quyue.aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    // @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}*/

public class WebMvcConfig{

}

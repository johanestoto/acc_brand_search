package com.acc.brand.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Component
public class ConfigInterceptor extends WebMvcConfigurerAdapter {

 
    private  RequestValidationInterceptor interceptor;

 
    public ConfigInterceptor() {
    }

    @Autowired
    public void setHandlerInterceptor(RequestValidationInterceptor interceptor) {
        this.interceptor = interceptor;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }

}

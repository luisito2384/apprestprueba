package com.genesys.api.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.genesys.api.filter.LogInterceptor;

@EnableWebMvc
@Configuration
@ComponentScan("com.genesys.api.controller")
public class MvcConfig implements WebMvcConfigurer {

    public MvcConfig() {
        super();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
       // registry.addInterceptor(new UserInterceptor());
      //  registry.addInterceptor(new SessionTimerInterceptor());
    }
}

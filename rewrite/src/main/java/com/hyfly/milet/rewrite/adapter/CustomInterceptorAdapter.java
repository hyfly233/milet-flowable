package com.hyfly.milet.rewrite.adapter;

import com.hyfly.milet.rewrite.filter.FlowableHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomInterceptorAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FlowableHandlerInterceptor())
                .addPathPatterns("/**");
    }
}
package com.example.springbootdemo.config;

import com.example.springbootdemo.custom.CustomGroupEntityManagerImpl;
import com.example.springbootdemo.custom.CustomIdmIdentityServiceImpl;
import com.example.springbootdemo.custom.CustomUserEntityManagerImpl;
import com.example.springbootdemo.service.CustomIdentityService;
import org.flowable.idm.spring.SpringIdmEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowableIdmConfig {

    @Autowired
    private CustomIdentityService customIdentityService;

    @Bean
    public EngineConfigurationConfigurer<SpringIdmEngineConfiguration> customIdmEngineConfigurer() {
        return cfg -> {
            cfg.setIdmIdentityService(new CustomIdmIdentityServiceImpl(customIdentityService, cfg.getIdmEngineConfiguration()));
            cfg.setGroupEntityManager(new CustomGroupEntityManagerImpl(customIdentityService, cfg, cfg.getGroupDataManager()));
            cfg.setUserEntityManager(new CustomUserEntityManagerImpl(customIdentityService, cfg, cfg.getUserDataManager()));
        };
    }
}

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
        return configuration -> {
            configuration.setIdmIdentityService(new CustomIdmIdentityServiceImpl(customIdentityService, configuration.getIdmEngineConfiguration()));
            configuration.setGroupEntityManager(new CustomGroupEntityManagerImpl(customIdentityService, configuration, configuration.getGroupDataManager()));
            configuration.setUserEntityManager(new CustomUserEntityManagerImpl(customIdentityService, configuration, configuration.getUserDataManager()));
        };
    }
}

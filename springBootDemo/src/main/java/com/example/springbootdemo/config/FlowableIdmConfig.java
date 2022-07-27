package com.example.springbootdemo.config;

import com.example.springbootdemo.custom.CustomGroupEntityManagerImpl;
import com.example.springbootdemo.custom.CustomIdmIdentityServiceImpl;
import com.example.springbootdemo.custom.CustomUserEntityManagerImpl;
import org.flowable.idm.spring.SpringIdmEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowableIdmConfig {

    @Bean
    public EngineConfigurationConfigurer<SpringIdmEngineConfiguration> customIdmEngineConfigurer() {
        return configuration -> {
            configuration.setIdmIdentityService(new CustomIdmIdentityServiceImpl(configuration.getIdmEngineConfiguration()));
            configuration.setGroupEntityManager(new CustomGroupEntityManagerImpl(configuration, configuration.getGroupDataManager()));
            configuration.setUserEntityManager(new CustomUserEntityManagerImpl(configuration, configuration.getUserDataManager()));
        };
    }
}

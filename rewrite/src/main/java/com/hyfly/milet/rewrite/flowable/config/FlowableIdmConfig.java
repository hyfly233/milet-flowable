package com.hyfly.milet.rewrite.flowable.config;

import com.hyfly.milet.rewrite.flowable.config.custom.CustomGroupEntityManagerImpl;
import com.hyfly.milet.rewrite.flowable.config.custom.CustomIdmIdentityServiceImpl;
import com.hyfly.milet.rewrite.flowable.config.custom.CustomUserEntityManagerImpl;
import com.hyfly.milet.rewrite.flowable.service.CustomIdentityService;
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
            cfg.setIdmIdentityService(new CustomIdmIdentityServiceImpl(customIdentityService));
            cfg.setGroupEntityManager(new CustomGroupEntityManagerImpl(customIdentityService, cfg, cfg.getGroupDataManager()));
            cfg.setUserEntityManager(new CustomUserEntityManagerImpl(customIdentityService, cfg, cfg.getUserDataManager()));
        };
    }
}

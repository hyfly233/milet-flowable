package com.example.springbootdemo.config;

import org.flowable.idm.spring.SpringIdmEngineConfiguration;
import org.flowable.spring.boot.FlowableProperties;
import org.flowable.spring.boot.idm.FlowableIdmProperties;
import org.flowable.spring.boot.idm.IdmEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class FlowableIdmConfig extends IdmEngineAutoConfiguration {

    public FlowableIdmConfig(FlowableProperties flowableProperties, FlowableIdmProperties idmProperties) {
        super(flowableProperties, idmProperties);
    }
    
    @Bean
    @Override
    @Autowired
    @ConditionalOnMissingBean
    public SpringIdmEngineConfiguration idmEngineConfiguration(DataSource dataSource, PlatformTransactionManager platformTransactionManager) {
        SpringIdmEngineConfiguration configuration = super.idmEngineConfiguration(dataSource, platformTransactionManager);

        configuration.setUserEntityManager(new CustomUserEntityManager(configuration, configuration.getUserDataManager()));
        configuration.setGroupEntityManager(new CustomGroupEntityManager(configuration, configuration.getGroupDataManager()));

        return configuration;
    }
}

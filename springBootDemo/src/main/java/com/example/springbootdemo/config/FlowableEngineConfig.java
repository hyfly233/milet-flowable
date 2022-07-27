package com.example.springbootdemo.config;

import org.flowable.common.engine.impl.cfg.IdGenerator;
import org.flowable.job.service.impl.asyncexecutor.AsyncExecutor;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.FlowableHttpProperties;
import org.flowable.spring.boot.FlowableMailProperties;
import org.flowable.spring.boot.FlowableProperties;
import org.flowable.spring.boot.ProcessEngineAutoConfiguration;
import org.flowable.spring.boot.app.FlowableAppProperties;
import org.flowable.spring.boot.idm.FlowableIdmProperties;
import org.flowable.spring.boot.process.FlowableProcessProperties;
import org.flowable.spring.boot.process.Process;
import org.flowable.spring.boot.process.ProcessAsync;
import org.flowable.spring.boot.process.ProcessAsyncHistory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class FlowableEngineConfig extends ProcessEngineAutoConfiguration {

    public FlowableEngineConfig(FlowableProperties flowableProperties, FlowableProcessProperties processProperties, FlowableAppProperties appProperties, FlowableIdmProperties idmProperties, FlowableMailProperties mailProperties, FlowableHttpProperties httpProperties) {
        super(flowableProperties, processProperties, appProperties, idmProperties, mailProperties, httpProperties);
    }


    @Bean
    @Override
    @Autowired
    @ConditionalOnMissingBean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(DataSource dataSource, PlatformTransactionManager platformTransactionManager,
                                                                             @Process ObjectProvider<IdGenerator> processIdGenerator,
                                                                             ObjectProvider<IdGenerator> globalIdGenerator,
                                                                             @ProcessAsync ObjectProvider<AsyncExecutor> asyncExecutorProvider,
                                                                             @ProcessAsyncHistory ObjectProvider<AsyncExecutor> asyncHistoryExecutorProvider) throws IOException {
        SpringProcessEngineConfiguration conf = super.springProcessEngineConfiguration(dataSource, platformTransactionManager, processIdGenerator, globalIdGenerator, asyncExecutorProvider, asyncHistoryExecutorProvider);
        
        String databaseSchema = conf.getDatabaseSchema();
        conf.setDatabaseCatalog(databaseSchema);
        conf.setDatabaseTablePrefix(databaseSchema + ".");
        conf.setTablePrefixIsSchema(true);

        conf.setActivityFontName("黑体");
        conf.setLabelFontName("黑体");
        conf.setAnnotationFontName("黑体");
        return conf;
    }
}

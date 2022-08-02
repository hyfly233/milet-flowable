该项目的主要是做一个使用自定义用户的样例

+ 配置了 IdmEngineConfiguration （FlowableIdmConfig.class）
+ 重写了原有的 IdmIdentityServiceImpl （CustomIdmIdentityServiceImpl.class）
+ 重写了原有的 UserQueryImpl （CustomUserEntityManagerImpl.class，CustomUserQueryImpl.class）
+ 重写了原有的 GroupQueryImpl （CustomGroupEntityManagerImpl.class，CustomGroupQueryImpl.class）
+ 屏蔽了 flowable-ui 的 security （感觉还有更好的解决方案，FlowableUiSecurityAutoConfiguration.class）
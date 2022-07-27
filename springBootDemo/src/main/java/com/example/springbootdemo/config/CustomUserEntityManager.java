package com.example.springbootdemo.config;

import org.flowable.idm.api.User;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.flowable.idm.engine.impl.UserQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntity;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityManagerImpl;
import org.flowable.idm.engine.impl.persistence.entity.data.UserDataManager;

import java.util.List;

public class CustomUserEntityManager extends UserEntityManagerImpl {

    public CustomUserEntityManager(IdmEngineConfiguration idmEngineConfiguration, UserDataManager userDataManager) {
        super(idmEngineConfiguration, userDataManager);
    }

    @Override
    public UserEntity findById(String entityId) {
        return null;
    }

    @Override
    public List<User> findUserByQueryCriteria(UserQueryImpl query) {
        return null;
    }

    @Override
    public long findUserCountByQueryCriteria(UserQueryImpl query) {
        return 0;
    }
}

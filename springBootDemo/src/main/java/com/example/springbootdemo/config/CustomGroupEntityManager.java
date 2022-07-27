package com.example.springbootdemo.config;

import org.flowable.idm.api.Group;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.flowable.idm.engine.impl.GroupQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntity;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityManagerImpl;
import org.flowable.idm.engine.impl.persistence.entity.data.GroupDataManager;

import java.util.List;

public class CustomGroupEntityManager extends GroupEntityManagerImpl {

    public CustomGroupEntityManager(IdmEngineConfiguration idmEngineConfiguration, GroupDataManager groupDataManager) {
        super(idmEngineConfiguration, groupDataManager);
    }

    @Override
    public GroupEntity findById(String entityId) {
        return null;
    }

    @Override
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query) {
        return null;
    }

    @Override
    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        return 0;
    }
}

package com.example.springbootdemo.custom;

import org.flowable.idm.api.Group;
import org.flowable.idm.api.GroupQuery;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.flowable.idm.engine.impl.GroupQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntity;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityManagerImpl;
import org.flowable.idm.engine.impl.persistence.entity.data.GroupDataManager;

import java.util.List;
import java.util.Map;

public class CustomGroupEntityManagerImpl extends GroupEntityManagerImpl {

    public CustomGroupEntityManagerImpl(IdmEngineConfiguration idmEngineConfiguration, GroupDataManager groupDataManager) {
        super(idmEngineConfiguration, groupDataManager);
    }

    @Override
    public Group createNewGroup(String groupId) {
        GroupEntity groupEntity = dataManager.create();
        groupEntity.setId(groupId);
        groupEntity.setRevision(0);
        return groupEntity;
    }

    @Override
    public GroupQuery createNewGroupQuery() {
        return new GroupQueryImpl(getCommandExecutor());
    }

    @Override
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query) {
        return dataManager.findGroupByQueryCriteria(query);
    }

    @Override
    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        return dataManager.findGroupCountByQueryCriteria(query);
    }

    @Override
    public List<Group> findGroupsByUser(String userId) {
        return dataManager.findGroupsByUser(userId);
    }

    @Override
    public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap) {
        return dataManager.findGroupsByNativeQuery(parameterMap);
    }

    @Override
    public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
        return dataManager.findGroupCountByNativeQuery(parameterMap);
    }

    @Override
    public List<Group> findGroupsByPrivilegeId(String privilegeId) {
        return dataManager.findGroupsByPrivilegeId(privilegeId);
    }

    @Override
    public boolean isNewGroup(Group group) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void delete(String groupId) {
        throw new RuntimeException("Not implemented");
    }


}

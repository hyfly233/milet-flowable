package com.hyfly.milet.rewrite.flowable.config.custom;

import com.hyfly.milet.rewrite.pojo.dto.SysRole;
import com.hyfly.milet.rewrite.flowable.service.CustomIdentityService;
import com.hyfly.milet.rewrite.utils.FlowableConvertUtils;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.GroupQuery;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.flowable.idm.engine.impl.GroupQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntity;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityManagerImpl;
import org.flowable.idm.engine.impl.persistence.entity.data.GroupDataManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomGroupEntityManagerImpl extends GroupEntityManagerImpl {

    private final CustomIdentityService customIdentityService;

    public CustomGroupEntityManagerImpl(CustomIdentityService customIdentityService, IdmEngineConfiguration idmEngineConfiguration, GroupDataManager groupDataManager) {
        super(idmEngineConfiguration, groupDataManager);
        this.customIdentityService = customIdentityService;
    }

    @Override
    public GroupQuery createNewGroupQuery() {
        return new CustomGroupQueryImpl(customIdentityService);
    }

    @Override
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query) {
        // TODO: 2022/7/28
        List<Group> groupList = new ArrayList<>();

        if (query.getUserId() != null) {
            List<SysRole> roles = customIdentityService.getRoleByUserId(query.getUserId());

            if (!roles.isEmpty()) {
                roles.forEach(role -> {
                    GroupEntity groupEntity = new GroupEntityImpl();
                    groupEntity.setId(role.getId());
                    groupEntity.setName(role.getRoleCode());
                    groupEntity.setType(role.getRoleCode());

                    groupList.add(groupEntity);
                });
            }
        }
        return groupList;
    }

    @Override
    public List<Group> findGroupsByUser(String userId) {

        List<Group> groupList = new ArrayList<>();

        if (userId != null && userId.length() > 0) {
            List<SysRole> roles = customIdentityService.getRoleByUserId(userId);

            if (!roles.isEmpty()) {
                roles.forEach(role -> groupList.add(FlowableConvertUtils.toGroupEntity(role)));
            }
        }
        return groupList;
    }

    // ----------- 不在此处实现 -----------

    @Override
    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Group createNewGroup(String groupId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Group> findGroupsByPrivilegeId(String privilegeId) {
        throw new RuntimeException("Not implemented");
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
package com.example.springbootdemo.custom;

import com.example.springbootdemo.pojo.dto.SysRole;
import com.example.springbootdemo.service.CustomIdentityService;
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

//@Component
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

        List<Group> groupList = new ArrayList<>();

//        if (query.getId() != null) {
//            SysRole role = sysRoleMapper.selectById(query.getId());
//
//            if (role != null) {
//                GroupEntity groupEntity = new GroupEntityImpl();
//                groupEntity.setId(role.getId());
//                groupEntity.setName(role.getRoleCode());
//                groupEntity.setType(role.getRoleCode());
//
//                return List.of(groupEntity);
//            }
//        }
//
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
//
//        if (query.getName() != null && query.getName().size() > 0) {
//            List<SysRole> roles = sysRoleMapper.selectByRoleCode(query.getName());
//
//            if (roles != null && roles.size() > 0) {
//                return roles.stream().map(role -> {
//                    GroupEntity groupEntity = new GroupEntityImpl();
//                    groupEntity.setId(role.getId());
//                    groupEntity.setName(role.getRoleCode());
//                    groupEntity.setType(role.getRoleCode());
//
//                    return groupEntity;
//                }).collect(List.collector());
//            }
//        }

        return groupList;
    }

    @Override
    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        return 0;
    }

    @Override
    public List<Group> findGroupsByUser(String userId) {

        List<Group> groupList = new ArrayList<>();

        if (userId != null && userId.length() > 0) {
            List<SysRole> roles = customIdentityService.getRoleByUserId(userId);

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
    public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap) {
        List<Group> groupList = new ArrayList<>();
        return groupList;
    }

    @Override
    public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
        return 0;
    }

    // ----------- 不在此处实现 -----------

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

package com.example.springbootdemo.custom;

import com.example.springbootdemo.dao.SysRoleMapper;
import com.example.springbootdemo.pojo.dto.SysRole;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.GroupQuery;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.flowable.idm.engine.impl.GroupQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntity;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityManagerImpl;
import org.flowable.idm.engine.impl.persistence.entity.data.GroupDataManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomGroupEntityManagerImpl extends GroupEntityManagerImpl {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public CustomGroupEntityManagerImpl(IdmEngineConfiguration idmEngineConfiguration, GroupDataManager groupDataManager) {
        super(idmEngineConfiguration, groupDataManager);
    }

    @Override
    public Group createNewGroup(String groupId) {
        SysRole role = sysRoleMapper.selectById(groupId);

        if (role != null) {
            GroupEntity groupEntity = new GroupEntityImpl();
            groupEntity.setId(role.getId());
            groupEntity.setName(role.getRoleCode());
            groupEntity.setType(role.getRoleCode());

            return groupEntity;
        }

        return null;
    }

    @Override
    public GroupQuery createNewGroupQuery() {
        return new GroupQueryImpl(getCommandExecutor());
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
//        if (query.getUserId() != null) {
//            SysRole role = sysRoleMapper.selectByUserId(query.getUserId());
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

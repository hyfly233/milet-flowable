package com.hyfly.milet.rewrite.flowable.config.custom;

import com.hyfly.milet.rewrite.flowable.service.CustomIdentityService;
import com.hyfly.milet.rewrite.utils.FlowableConvertUtils;
import org.flowable.idm.api.*;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.flowable.idm.engine.impl.UserQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntity;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityManagerImpl;
import org.flowable.idm.engine.impl.persistence.entity.data.UserDataManager;

import java.util.List;
import java.util.Map;

public class CustomUserEntityManagerImpl extends UserEntityManagerImpl {

    private final CustomIdentityService customIdentityService;

    public CustomUserEntityManagerImpl(CustomIdentityService customIdentityService, IdmEngineConfiguration idmEngineConfiguration, UserDataManager userDataManager) {
        super(idmEngineConfiguration, userDataManager);
        this.customIdentityService = customIdentityService;
    }

    @Override
    public UserEntity findById(String entityId) {
        return FlowableConvertUtils.toUserEntity(customIdentityService.getUserById(entityId));
    }

    @Override
    public UserQuery createNewUserQuery() {
        return new CustomUserQueryImpl(customIdentityService);
    }

    // ----------- 不在此处实现 -----------

    @Override
    public List<User> findUserByQueryCriteria(UserQueryImpl query) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public long findUserCountByQueryCriteria(UserQueryImpl query) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<User> findUsersByPrivilegeId(String name) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public User createNewUser(String userId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Picture getUserPicture(User user) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean isNewUser(User user) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setUserPicture(User user, Picture picture) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Boolean checkPassword(String userId, String password, PasswordEncoder passwordEncoder, PasswordSalt salt) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void updateUser(User updatedUser) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void delete(UserEntity userEntity) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deletePicture(User user) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void delete(String userId) {
        throw new RuntimeException("Not implemented");
    }
}
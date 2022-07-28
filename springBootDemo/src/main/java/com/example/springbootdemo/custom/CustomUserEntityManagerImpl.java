package com.example.springbootdemo.custom;

import com.example.springbootdemo.service.CustomIdentityService;
import org.flowable.idm.api.*;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.flowable.idm.engine.impl.UserQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntity;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityManagerImpl;
import org.flowable.idm.engine.impl.persistence.entity.data.UserDataManager;

import java.util.List;
import java.util.Map;

public class CustomUserEntityManagerImpl extends UserEntityManagerImpl {

    private CustomIdentityService customIdentityService;

    public CustomUserEntityManagerImpl(CustomIdentityService customIdentityService, IdmEngineConfiguration idmEngineConfiguration, UserDataManager userDataManager) {
        super(idmEngineConfiguration, userDataManager);
        this.customIdentityService = customIdentityService;
    }

    @Override
    public UserEntity findById(String entityId) {
        return null;
    }

    @Override
    public User createNewUser(String userId) {
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

    @Override
    public UserQuery createNewUserQuery() {
        return null;
    }


    @Override
    public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap) {
        return null;
    }

    @Override
    public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
        return 0;
    }

    @Override
    public List<User> findUsersByPrivilegeId(String name) {
        return dataManager.findUsersByPrivilegeId(name);
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

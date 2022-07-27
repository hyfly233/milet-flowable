package com.example.springbootdemo.custom;

import org.flowable.idm.api.*;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.flowable.idm.engine.impl.IdmIdentityServiceImpl;
import org.flowable.idm.engine.impl.NativeTokenQueryImpl;
import org.flowable.idm.engine.impl.UserQueryImpl;
import org.flowable.idm.engine.impl.cmd.*;

import java.util.List;

public class CustomIdmIdentityServiceImpl extends IdmIdentityServiceImpl {

    public CustomIdmIdentityServiceImpl(IdmEngineConfiguration idmEngineConfiguration) {
        super(idmEngineConfiguration);
    }

    @Override
    public String getUserInfo(String userId, String key) {

        // todo
        return null;
    }

    @Override
    public List<String> getUserInfoKeys(String userId) {
        // todo
        return null;
    }

    @Override
    public Picture getUserPicture(String userId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Group newGroup(String groupId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public User newUser(String userId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void saveGroup(Group group) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void saveUser(User user) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void updateUserPassword(User user) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public UserQuery createUserQuery() {
        // TODO: 2022/7/27 暂时不实现
        UserQueryImpl query = new UserQueryImpl();

        query.setParameter("userId");

        return query;
    }

    @Override
    public NativeUserQuery createNativeUserQuery() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public GroupQuery createGroupQuery() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public NativeGroupQuery createNativeGroupQuery() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void createMembership(String userId, String groupId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteGroup(String groupId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteMembership(String userId, String groupId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean checkPassword(String userId, String password) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteUser(String userId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setUserPicture(String userId, Picture picture) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setAuthenticatedUserId(String authenticatedUserId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setUserInfo(String userId, String key, String value) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteUserInfo(String userId, String key) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Token newToken(String tokenId) {
        return commandExecutor.execute(new CreateTokenCmd(tokenId));
    }

    @Override
    public void saveToken(Token token) {
        commandExecutor.execute(new SaveTokenCmd(token, configuration));
    }

    @Override
    public void deleteToken(String tokenId) {
        commandExecutor.execute(new DeleteTokenCmd(tokenId));
    }

    @Override
    public TokenQuery createTokenQuery() {
        return commandExecutor.execute(new CreateTokenQueryCmd());
    }

    @Override
    public NativeTokenQuery createNativeTokenQuery() {
        return new NativeTokenQueryImpl(commandExecutor);
    }


    @Override
    public Privilege createPrivilege(String name) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void addUserPrivilegeMapping(String privilegeId, String userId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteUserPrivilegeMapping(String privilegeId, String userId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void addGroupPrivilegeMapping(String privilegeId, String groupId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteGroupPrivilegeMapping(String privilegeId, String groupId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<PrivilegeMapping> getPrivilegeMappingsByPrivilegeId(String privilegeId) {
        return commandExecutor.execute(new GetPrivilegeMappingsByPrivilegeIdCmd(privilegeId));
    }

    @Override
    public void deletePrivilege(String id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public PrivilegeQuery createPrivilegeQuery() {
        return commandExecutor.execute(new CreatePrivilegeQueryCmd());
    }

    @Override
    public List<Group> getGroupsWithPrivilege(String name) {
        return commandExecutor.execute(new GetGroupsWithPrivilegeCmd(name));
    }

    @Override
    public List<User> getUsersWithPrivilege(String name) {
        return commandExecutor.execute(new GetUsersWithPrivilegeCmd(name));
    }
}

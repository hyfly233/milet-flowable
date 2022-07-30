package com.hyfly.milet.rewrite.custom;

import com.hyfly.milet.rewrite.service.CustomIdentityService;
import org.flowable.idm.api.*;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.flowable.idm.engine.impl.IdmIdentityServiceImpl;

import java.util.List;

/**
 * @author hyfly
 */
public class CustomIdmIdentityServiceImpl extends IdmIdentityServiceImpl {

    private CustomIdentityService customIdentityService;

    public CustomIdmIdentityServiceImpl(CustomIdentityService customIdentityService, IdmEngineConfiguration idmEngineConfiguration) {
        super(idmEngineConfiguration);
        this.customIdentityService = customIdentityService;
    }

    @Override
    public UserQuery createUserQuery() {
        return new CustomUserQueryImpl(customIdentityService);
    }

    @Override
    public GroupQuery createGroupQuery() {
        return new CustomGroupQueryImpl(customIdentityService);
    }

    /**
     * 在流程开始的业务逻辑中（startEvent）使用，flowable 将 userId 存入 act_hi_procinst 表中
     *
     * @param authenticatedUserId 开启流程的 userId
     */
    @Override
    public void setAuthenticatedUserId(String authenticatedUserId) {
        super.setAuthenticatedUserId(authenticatedUserId);
    }

    // ----------- 不在此处实现 -----------

    @Override
    public String getUserInfo(String userId, String key) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<String> getUserInfoKeys(String userId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public NativeUserQuery createNativeUserQuery() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public NativeGroupQuery createNativeGroupQuery() {
        throw new RuntimeException("Not implemented");
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
    public void deleteUser(String userId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteUserInfo(String userId, String key) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteToken(String tokenId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean checkPassword(String userId, String password) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setUserPicture(String userId, Picture picture) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setUserInfo(String userId, String key, String value) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Token newToken(String tokenId) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void saveToken(Token token) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public TokenQuery createTokenQuery() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public NativeTokenQuery createNativeTokenQuery() {
        throw new RuntimeException("Not implemented");
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
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deletePrivilege(String id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public PrivilegeQuery createPrivilegeQuery() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Group> getGroupsWithPrivilege(String name) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<User> getUsersWithPrivilege(String name) {
        throw new RuntimeException("Not implemented");
    }
}

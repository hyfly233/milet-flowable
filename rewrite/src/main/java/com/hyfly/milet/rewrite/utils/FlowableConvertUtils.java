package com.hyfly.milet.rewrite.utils;

import com.hyfly.milet.rewrite.pojo.dto.SysRole;
import com.hyfly.milet.rewrite.pojo.dto.SysUser;
import org.flowable.idm.api.Group;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntity;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntity;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;

/**
 * 用户转换工具类
 *
 * @author
 */
public class FlowableConvertUtils {

    public static UserEntity toUserEntity(SysUser user) {
        if (user == null) {
            return null;
        }

        UserEntity userEntity = new UserEntityImpl();
        userEntity.setId(user.getId());
        userEntity.setDisplayName(user.getUsername());
        userEntity.setEmail(user.getEmail());

        return userEntity;
    }

    public static Group toGroupEntity(SysRole sysRole) {
        if (sysRole == null) {
            return null;
        }

        GroupEntity group = new GroupEntityImpl();
        group.setId(sysRole.getId());
        group.setName(sysRole.getRoleName());
        group.setType(sysRole.getRoleCode());
        return group;
    }
}
package com.example.demo.flowable.filter;

import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.flowable.ui.common.security.SecurityUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户模拟登录
 */
@Component
public class FlowableHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        String servletPath = request.getServletPath();

        if (servletPath.startsWith("/app")) {
            User user = new UserEntityImpl();
            user.setId("admin");
            SecurityUtils.assumeUser(user);
        }
        return true;
    }
}
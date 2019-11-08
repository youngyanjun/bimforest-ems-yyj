package com.bimforest.ems.common.utils;

import com.bimforest.ems.common.entity.UserSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author max.zhang
 * @title: UserSessionUtils
 * @projectName bimforest
 * @description: 用户session工具类
 * @date 2019/9/1813:27
 * @Copyright (C) 量树科技
 */
@Component
public class UserSessionUtils {

    @Autowired
    RedisUtils redisUtils;

    private ThreadLocal<String> userToken = new ThreadLocal<>();

    public void setUserTokenValue(String authToken) {
        userToken.set(authToken);
    }

    public String getUserTokenValue() {
        return userToken.get();
    }

    public UserSession getUserSession() {
        UserSession userSession = null;
        String authToken = getUserTokenValue();
        if (StringUtils.isNotBlank(authToken)) {
            userSession = (UserSession) redisUtils.get(authToken);
        }
        return userSession;
    }

}

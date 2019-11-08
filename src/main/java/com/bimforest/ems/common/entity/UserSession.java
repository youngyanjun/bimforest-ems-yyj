package com.bimforest.ems.common.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @author max.zhang
 * @title: UserSession
 * @projectName bimforest
 * @description: 用户session
 * @date 2019/9/1813:27
 * @Copyright (C) 量树科技
 */
@Data
public class UserSession implements Serializable {
    // session id
    private String token;
    // 用户账号
    private String account;
    //登录手机
    private String phone;
    //登录邮箱
    private  String eMail;
    // 用户登录时间
    private  long loginTime;
    // 是否为管理员
    private boolean adminFlag;
    // 用户所在部门名称
    private String departmentName;
    // 用户信息
//    private SysUser sysUser;
    // 登录类型 1：pc 2：APP
    private int accountType;


}

package com.bimforest.ems.modules.sys.vo;

import lombok.Data;

/**
 * @author max.zhang
 * @title: LoginVO
 * @projectName zcloud-bi
 * @description: 登录VO
 * @date 2019/7/29:13
 */
@Data
public class LoginVO {

    // 用户账号
    private String phone;
    // 用户密码
    private String password;
}

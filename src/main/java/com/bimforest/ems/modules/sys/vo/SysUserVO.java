package com.bimforest.ems.modules.sys.vo;

import lombok.Data;

/**
 * @author youngyanjun
 * @date 2019-11-05 16:54
 */
@Data
public class SysUserVO {
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 邮箱
     */
    private String eMail;

    /**
     * 手机
     */
    private String phone;
    /**
     * 所在项目数
     */
    private String engineeringSum;

}

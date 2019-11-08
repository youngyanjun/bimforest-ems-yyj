package com.bimforest.ems.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bimforest.ems.pojo.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户管理表
 * </p>
 *
 * @author youngyanjun
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 备注
     */
    private String remark;


    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 邮箱
     */
    private String eMail;

    /**
     * 手机
     */
    private String phone;

    /**
     * 用户账号是否冻结
     */
    private String isFreeze;

    /**
     * 自动保存时间设置
     */
    private String saveTime;


}

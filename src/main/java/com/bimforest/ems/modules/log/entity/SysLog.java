package com.bimforest.ems.modules.log.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;

import com.bimforest.ems.pojo.BaseEntity;
import com.sun.xml.bind.v2.model.core.ID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统操作日志
 * </p>
 *
 * @author youngyanjun
 * @since 2019-11-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_log")
public class SysLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 操作用户
     */
    private String userPhone;

    /**
     * 操作模块
     */
    private String module;

    /**
     * 用户行为--操作行为（function）
     */
    private String action;




}

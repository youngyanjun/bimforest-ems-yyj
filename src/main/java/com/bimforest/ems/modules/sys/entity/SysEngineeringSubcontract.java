package com.bimforest.ems.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bimforest.ems.pojo.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分包商表
 * </p>
 *
 * @author youngyanjun
 * @since 2019-11-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("engineering_subcontract")
public class SysEngineeringSubcontract extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 分包商名称
     */
    private String unitName;

    /**
     * 企业法定代表人
     */
    private String juridicalPerson;

    /**
     * 纳税人识别号
     */
    private String taxCode;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 电话
     */
    private String phone;

    /**
     * 类型
     */
    private String type;

    /**
     * 备注
     */
    private String remark;

}

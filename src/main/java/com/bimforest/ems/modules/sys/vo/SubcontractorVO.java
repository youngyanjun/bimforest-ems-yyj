package com.bimforest.ems.modules.sys.vo;

import lombok.Data;

/**
 * @author youngyanjun
 * @date 2019-11-04 15:21
 */
@Data
public class SubcontractorVO {
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
     * 备注
     */
    private String remark;

}

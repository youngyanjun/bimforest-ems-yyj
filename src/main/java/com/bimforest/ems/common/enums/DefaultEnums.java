package com.bimforest.ems.common.enums;

/**
 * @author youngyanjun
 * @date 2019-11-01 16:49
 */
public enum  DefaultEnums {

    DEFAULT_PASSWORD("123","默认用户密码");






    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    DefaultEnums(String acode, String amessage) {
        this.code = acode;
        this.message = amessage;
    }

}

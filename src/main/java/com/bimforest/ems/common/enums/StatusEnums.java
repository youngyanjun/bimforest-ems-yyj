package com.bimforest.ems.common.enums;

import javax.swing.*;

/**
　* @description: 状态
　* @author max.zhang
　* @date 2019/5/8 13:44
　*/
public enum StatusEnums {

    STATUS_VALID((byte) 1, "有效"),
    STATUS_INVALID((byte) -1, "无效"),
    ENABLED_Y((byte) 1, "启用"),
    ENABLED_N((byte) -1, "禁用"),
    DISABLE((byte) 3, "冻结");





    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    StatusEnums(int acode, String amessage) {
        this.code = acode;
        this.message = amessage;
    }


}

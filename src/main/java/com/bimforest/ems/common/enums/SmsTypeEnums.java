package com.bimforest.ems.common.enums;

/**
 * @author max.zhang
 * @title: SmsTypeEnums
 * @projectName bimforest
 * @description: 发送短信类型
 * @date 2019/10/2315:53
 * @Copyright (C) 量树科技
 */
public enum SmsTypeEnums {

  SMS_UPDATE_PASSWORD("SMS_UPDATE_PASSWORD", "更新密码"),
  SMS_LOGIN("SMS_LOGIN", "登录");


  private String code;


  private String message;

  public String getCode() {
    return code;
  }


  public String getMessage() {
    return message;
  }

  SmsTypeEnums(String code, String message) {
    this.code = code;
    this.message = message;
  }

}

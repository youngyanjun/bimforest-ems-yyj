package com.bimforest.ems.common.enums;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * 　* @description: TODO
 * 　* @author max.zhang
 * 　* @date 2019/7/3 10:42
 *
 */
public enum MessageEnums {

  /**
   * 请求处理成功[2000]
   */
  //FIAL_SYS_2000("SYS", "SYS2000", "邮箱或手机号已经存在"),

  FIAL_SYS_2001("SYS", "SYS2001", "邮箱或手机号已经存在"),

  FIAL_SYS_4000("SYS", "SYS4000", "操作失败"),

  FIAL_SYS_2002("SYS", "SYS2002", "该用户还没有登录"),
  FIAL_SYS_2003("SYS", "SYS2003", "用户名或密码不正确"),
  FIAL_SYS_2004("SYS", "SYS2004", "手机号格式不正确"),
  FIAL_SYS_2005("SYS", "SYS2005", "系统中不存在该用户对应的手机号"),
  FIAL_SYS_2006("SYS", "SYS2006", "找回密码的短信60S内只能发送一次"),
  FIAL_SYS_2007("SYS", "SYS2007", "发送短信失败"),
  FIAL_SYS_2008("SYS", "SYS2008", "验证码错误"),
  FIAL_SYS_2009("SYS", "SYS2009", "手机号或邮箱格式错误"),
  FIAL_SYS_2010("SYS","SYS2010","企业名称或纳税人识别号已存在"),




    /*FIAL_SYS_2001("SYS", "SYS2001", "您没有访问权限，请联系管理员同步用户数据"),
    FIAL_SYS_2003("SYS", "SYS2003", "旧密码不正确"),
    FIAL_SYS_2004("SYS", "SYS2004", "角色名不能重复"),*/

  FIAL_WX_3001("WX", "WX3001", "企业微信消息发送失败"),;


  private String code;
  private String errorType;
  private String message;

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public String getErrorType() {
    return errorType;
  }

  MessageEnums(String aerrorType, String acode, String amessage) {
    this.errorType = aerrorType;
    this.code = acode;
    this.message = amessage;
  }

  public static MessageEnums getByCode(String code) {
    if (StringUtils.isEmpty(code)) {
      return null;
    }
    for (MessageEnums con : MessageEnums.values()) {
      if (con.getCode().equals(code)) {
        return con;
      }
    }
    return null;
  }

  public static MessageEnums getByErrorType(String errorType) {
    if (StringUtils.isEmpty(errorType)) {
      return null;
    }
    for (MessageEnums con : MessageEnums.values()) {
      if (con.getErrorType().equals(errorType)) {
        return con;
      }
    }
    return null;
  }
}

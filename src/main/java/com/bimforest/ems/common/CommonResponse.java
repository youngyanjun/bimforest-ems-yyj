package com.bimforest.ems.common;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bimforest.ems.common.enums.MessageEnums;
import com.bimforest.ems.common.enums.ResponseTypeEnums;

/**
 * 　* @description: 返回实体类
 * 　* @author max.zhang
 * 　* @date 2019/9/10 9:29
 * 　* @Copyright (C) 量树科技
 */
public class CommonResponse<T> {

  /**
   * 状态
   */
  private ResponseTypeEnums status;


  /**
   * 错误码
   */
  private String errorCode;


  /**
   * 错误消息
   */
  private String errorMsg;


  /**
   * 返回对象
   */
  private T result;

  public CommonResponse(ResponseTypeEnums success, String errorCode, Page page) {
  }

  public CommonResponse(ResponseTypeEnums status) {
    this.status = status;
  }

  public CommonResponse(MessageEnums messageEnums) {
    if (messageEnums == null) {
      this.status = ResponseTypeEnums.SUCCESS;
    } else {
      this.status = ResponseTypeEnums.FAILED;
      this.errorCode = messageEnums.getCode();
      this.errorMsg = messageEnums.getMessage();
    }
  }

  public CommonResponse(ResponseTypeEnums status, T result) {
    this.status = status;
    this.result = result;
  }

  public CommonResponse(ResponseTypeEnums status, String errorCode,
                        String errorMsg, T result) {
    this.status = status;
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
    this.result = result;
  }

  public CommonResponse(ResponseTypeEnums status, String errorCode,
                        String errorMsg) {
    this.status = status;
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public ResponseTypeEnums getStatus() {
    return status;
  }

  public void setStatus(ResponseTypeEnums status) {
    this.status = status;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

}

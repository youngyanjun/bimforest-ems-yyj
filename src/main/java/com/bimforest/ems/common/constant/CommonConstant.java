package com.bimforest.ems.common.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author max.zhang
 * @title: CommonConstant
 * @projectName bimforest
 * @description: TODO
 * @date 2019/9/1814:28
 * @Copyright (C) 量树科技
 */
public class CommonConstant {

  // session过期时间
  public static final long SESSION_EXPIRE_TIME = 60 * 60;

  // 为找回密码发送的短信验证码存放在Redis中，key的前缀
  public static final String UPDATE_PWD_VERIFICATION_CODE_REDIS_PREFIX = "update_pwd_verification_code_redis_prefix";


}

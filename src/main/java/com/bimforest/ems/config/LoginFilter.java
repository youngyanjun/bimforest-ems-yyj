package com.bimforest.ems.config;

import com.alibaba.fastjson.JSONObject;
import com.bimforest.ems.common.constant.CommonConstant;
import com.bimforest.ems.common.enums.MessageEnums;
import com.bimforest.ems.common.enums.ResponseTypeEnums;
import com.bimforest.ems.common.utils.RedisUtils;
import com.bimforest.ems.common.utils.UserSessionUtils;
import com.bimforest.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author max.zhang
 * @title: LoginFilter
 * @projectName bimforest
 * @description: 登录拦截
 * @date 2019/9/1813:27
 * @Copyright (C) 量树科技
 */
@Component
public class LoginFilter implements Filter {

  @Autowired
  UserSessionUtils userSessionUtils;
  @Autowired
  RedisUtils redisUtils;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    String token = "";
    Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
    if (cookies != null && cookies.length != 0) {
      for (Cookie cookie : cookies) {
        String name = cookie.getName();
        if (StrUtils.equals(name, "x-token")) {
          token = cookie.getValue();
        }
      }
    }
    String url = request.getRequestURI();


    // /api/facade: 外部服务，不需要登录校验
    if ((url.startsWith("/api/") && !url.startsWith("/api/facade")) || StrUtils.equals(url, "/api/facade/sys/logout")) {
      if (StringUtils.isBlank(token)) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(
          "application/json; charset=utf-8");
        PrintWriter out = null;
        JSONObject res = new JSONObject();
        res.put("status",
          ResponseTypeEnums.FAILED);
        res.put("errorCode",
          MessageEnums.FIAL_SYS_2002.getCode());
        res.put("errorMsg",
          MessageEnums.FIAL_SYS_2002.getMessage());
        out = response.getWriter();
        out.append(res.toString());
      } else {
        if (redisUtils.get(token) != null) {
          userSessionUtils.setUserTokenValue(token);
          redisUtils.expire(token, CommonConstant.SESSION_EXPIRE_TIME);
          response.setHeader("Cache-Control", "no-cache,must-revalidate");
          filterChain.doFilter(request, response);
        }

      }
    } else {
      filterChain.doFilter(request, response);
    }
  }


}

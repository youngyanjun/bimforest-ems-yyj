package com.bimforest.ems.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.bimforest.ems.common.CommonResponse;
import com.bimforest.ems.common.enums.MessageEnums;
import com.bimforest.ems.common.enums.ResponseTypeEnums;
import com.bimforest.ems.modules.sys.vo.LoginVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Security;

/**
 * @author youngyanjun
 * @date 2019-11-08 11:35
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("login")
    public String loing(@RequestBody LoginVO loginVO) {
        if (StringUtils.isEmpty(loginVO.getPhone()) || StringUtils.isEmpty(loginVO.getPassword())) {
//            return  new CommonResponse(ResponseTypeEnums.FAILED,
//                    MessageEnums.FIAL_SYS_2003.getCode(),MessageEnums.FIAL_SYS_2003.getMessage());
            return "错误";
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginVO.getPhone(), loginVO.getPassword());
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
//            return  new CommonResponse(ResponseTypeEnums.FAILED,
//                    MessageEnums.FIAL_SYS_2003.getCode(),MessageEnums.FIAL_SYS_2003.getMessage());
            return "错误";
        }
        try{
            subject.login(usernamePasswordToken);
        }catch (Exception e){
            e.printStackTrace();
            return "错误";
        }
//        return new CommonResponse(ResponseTypeEnums.SUCCESS);
        return "成功";
    }
}

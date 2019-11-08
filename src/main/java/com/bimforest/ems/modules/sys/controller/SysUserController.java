package com.bimforest.ems.modules.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bimforest.ems.annotation.OperationLog;
import com.bimforest.ems.bean.CustomParamConfig;
import com.bimforest.ems.common.CommonResponse;
import com.bimforest.ems.common.constant.ConfigConstant;
import com.bimforest.ems.common.enums.DefaultEnums;
import com.bimforest.ems.common.enums.MessageEnums;
import com.bimforest.ems.common.enums.ResponseTypeEnums;
import com.bimforest.ems.common.enums.StatusEnums;
import com.bimforest.ems.modules.sys.entity.SysUser;
import com.bimforest.ems.modules.sys.mapper.SysUserMapper;
import com.bimforest.ems.modules.sys.service.SysUserService;
import com.bimforest.ems.modules.sys.vo.SysUserVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jdk.nashorn.internal.ir.LiteralNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.bimforest.ems.common.utils.Md5Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author youngyanjun
 * @since 2019-10-30
 */
@RestController
@RequestMapping("/sys/sys-user")
public class SysUserController {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserService sysUserService;


    @ApiOperation(value = "人员管理---用户列表显示--查询操作")
    @GetMapping("/userList")
    public CommonResponse selecUserList(@ApiParam("通过姓名查找用户") String userName,
                                        @RequestParam(required = false, defaultValue = "10") @ApiParam("每页显示条数") int pageSize,
                                        @RequestParam(required = false, defaultValue = "1") @ApiParam("当前页码") int pageNum) {
        IPage<SysUser> page = new Page(pageNum, pageSize);
        IPage<SysUserVO> userListVOIPage = (IPage<SysUserVO>) sysUserService.selectList(page, userName);
        return new CommonResponse(ResponseTypeEnums.SUCCESS, userListVOIPage);
    }


    @ApiOperation(value = "人员管理---新增用户")
    @PostMapping("/insertUser")
    @OperationLog(module = "人员管理", action = "新建用户")
    @Transactional
    public CommonResponse insertUser(String userName, String eMail, String phone) {
        boolean checkPhoneEMail = sysUserService.checkPhoneEMail(eMail, phone);
        //设置默认密码
        String password = DefaultEnums.DEFAULT_PASSWORD.getCode();

        //判断邮箱和手机是否符合数据规则
        if (checkPhoneEMail) {
            //判断用户输入的邮箱和手机号是否已经存在
            boolean queryPhoneEmail = sysUserService.queryPhoneEmail(eMail, phone);
            if (queryPhoneEmail) {
                return new CommonResponse(ResponseTypeEnums.FAILED, MessageEnums.FIAL_SYS_2001.getCode(), MessageEnums.FIAL_SYS_2001.getMessage());
            }
            SysUser sysUser = new SysUser();
            sysUser.setUserName(userName);
            sysUser.setEMail(eMail);
            sysUser.setPhone(phone);
            //用户密码MD5加密+盐
            sysUser.setUserPwd(Md5Utils.string2MD5(password + CustomParamConfig.getSalt()));
            sysUserService.save(sysUser);
            return new CommonResponse(ResponseTypeEnums.SUCCESS);
        }
        return new CommonResponse(ResponseTypeEnums.FAILED, MessageEnums.FIAL_SYS_2009.getCode(), MessageEnums.FIAL_SYS_2009.getMessage());

    }


    @ApiOperation(value = "人员管理---批量冻结账号")
    @PostMapping("/updateAccount")
    public CommonResponse updateAccount(@ApiParam("需要批量更新（冻结账号）的用户ID") @RequestBody List<String> ids) {
        int status = StatusEnums.DISABLE.getCode();
        sysUserService.updateStatus(ids, status);
        return new CommonResponse(ResponseTypeEnums.SUCCESS);
    }

    @ApiOperation(value = "人员管理---删除用户")
    @PostMapping("/deleteAccount")
    public CommonResponse deleteAccount(@ApiParam("需要批量更新（删除用户）的用户ID") @RequestBody List<String> ids) {
        //获取删除账号标识
        int status = StatusEnums.ENABLED_N.getCode();
        sysUserService.updateStatus(ids, status);
        return new CommonResponse(ResponseTypeEnums.SUCCESS);
    }

    @ApiOperation(value = "人员管理---重置账号")
    @PostMapping("/updatePassword")
    public CommonResponse updatePassword(@ApiParam("需要批量更新（重置密码）的用户ID") @RequestBody List<String> ids) {
        //获取用户默认密码
        String password = DefaultEnums.DEFAULT_PASSWORD.getCode();
        //用户密码MD5加密+盐
        Md5Utils.string2MD5(password + CustomParamConfig.getSalt());
        //重置用户密码
        sysUserService.updatePassword(ids, Md5Utils.string2MD5(password + CustomParamConfig.getSalt()));
        return new CommonResponse(ResponseTypeEnums.SUCCESS);
    }




}
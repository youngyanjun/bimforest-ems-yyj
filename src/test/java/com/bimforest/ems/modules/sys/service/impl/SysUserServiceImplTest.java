package com.bimforest.ems.modules.sys.service.impl;

import com.bimforest.ems.modules.sys.entity.SysUser;
import com.bimforest.ems.modules.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author youngyanjun
 * @title: ${}
 * @date 2019-11-07 11:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysUserServiceImplTest {
    @Autowired
    SysUserService sysUserService;

    @Test
    public void selectByUserAccount() {
        SysUser sysUser = sysUserService.selectByUserAccount("13190909909");
        String phone = sysUser.getPhone();
        String eMail = sysUser.getEMail();
        String userPwd = sysUser.getUserPwd();
        System.out.println(phone+"********************");
    }
}
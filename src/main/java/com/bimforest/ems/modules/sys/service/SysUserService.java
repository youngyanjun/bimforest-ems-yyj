package com.bimforest.ems.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bimforest.ems.common.CommonResponse;
import com.bimforest.ems.modules.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bimforest.ems.modules.sys.vo.SysUserVO;
import sun.awt.image.IntegerComponentRaster;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author youngyanjun
 * @since 2019-10-30
 */
public interface SysUserService extends IService<SysUser> {

    //根据用户名---用户登录凭证---手机---Email从数据库中查询该用户
    SysUser selectByUserAccount(String account);

    //查出用户列表
    List<SysUserVO> selectList(IPage<SysUser>  page, String userName);

    //判断邮箱和手机是否符合数据规则
    boolean checkPhoneEMail(String eMail, String phone);

    //判断数据库中是否已经存在相同手机或邮箱
    boolean queryPhoneEmail(String eMail, String phone);

    //根据ID修改 status 的值
    int updateStatus(List<String> list ,int status);

    //根据用户ID修改用户密码
    int updatePassword(List<String>  list, String password);
}

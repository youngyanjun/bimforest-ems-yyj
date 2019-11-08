package com.bimforest.ems.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bimforest.ems.common.enums.StatusEnums;
import com.bimforest.ems.modules.sys.entity.SysUser;
import com.bimforest.ems.modules.sys.mapper.SysUserMapper;
import com.bimforest.ems.modules.sys.service.SysUserService;
import com.bimforest.ems.modules.sys.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author youngyanjun
 * @since 2019-10-30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserService sysUserService;

    /**
     * 根据用户名---用户登录账号---手机---Email从数据库中查询该用户
     * @param account
     * @return
     */
    @Override
    public SysUser selectByUserAccount(String account) {
        //查询条件构造器
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper();
        //通过“phone” 并且“status” 行 不为 “-1” 的条件查出用户信息（“status” 为 “-1” 是逻辑删除标志）
        queryWrapper.eq("phone", account).ne("status", StatusEnums.ENABLED_N.getCode());
        return sysUserMapper.selectOne(queryWrapper);
    }

    /**
     * 人员管理搜索，列表显示
     *
     * @param page
     * @param userName
     * @return
     */
    @Override
    public List<SysUserVO> selectList(IPage<SysUser> page, String userName) {
        //模糊查询用户及查询用户全部列表
        return sysUserMapper.selectUserList(userName);
    }

    /**
     * 判断邮箱和手机是否符合数据规则
     *
     * @param eMail
     * @param phone
     * @return
     */
    @Override
    public boolean checkPhoneEMail(String eMail, String phone) {
        if (StringUtils.isEmpty(eMail) | StringUtils.isEmpty(phone)) {
            return false;
        }
        String eMailTemplate = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
        String phoneTemplate = "[0-9-()（）]{7,18}";

        boolean isEMail = eMail.matches(eMailTemplate);
        boolean isPhone = phone.matches(phoneTemplate);

        if (isEMail && isPhone) {  //验证手机及邮箱都为真则返回 true
            return true;
        }
        return false;
    }

    /**
     * 查询数据库中是否已经存在相同手机或邮箱
     *
     * @param eMail
     * @param phone
     * @return
     */
    @Override
    public boolean queryPhoneEmail(String eMail, String phone) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper();
        queryWrapper.eq("e_mail", eMail).or().eq("phone", phone);
        if (sysUserMapper.selectCount(queryWrapper) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据ID修改status中的状态值
     * @param list
     * @return
     */
    @Override
    public int updateStatus(List<String> list,int status) {
        return sysUserMapper.updateStatus(list,status);
    }

    /**
     * 根据用户ID重置用户密码
     * @param list
     * @param password
     * @return
     */
    @Override
    public int updatePassword(List list, String password) {
        return  sysUserMapper.updatePassword(list,password);
    }
}

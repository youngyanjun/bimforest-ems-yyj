package com.bimforest.ems.shiro;

import com.bimforest.ems.bean.CustomParamConfig;
import com.bimforest.ems.common.constant.ConfigConstant;
import com.bimforest.ems.modules.sys.entity.SysUser;
import com.bimforest.ems.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author youngyanjun
 * @date 2019-11-07 10:03
 */
public class BimForestEMSRealm extends AuthorizingRealm {
    @Resource
    SysUserService sysUserService;
    /**
     * 权限自定义 Realm
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
//        List<?> sysRole =

/*        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user= (User) principalCollection.getPrimaryPrincipal();
        List<Role> roles=roleService.getRolesByUserId(user.getUserId());
        List<Menu> menus=menuService.getMenusByUserId(user.getUserId());
        simpleAuthorizationInfo.addRoles(roles.stream().map(Role::getRoleName).collect(Collectors.toSet()));
        simpleAuthorizationInfo.addStringPermissions(menus.stream().map(Menu::getPerms).collect(Collectors.toSet()));
        return simpleAuthorizationInfo;*/

        return null;
    }

    /**
     * 认证---登录---Realm
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 根据 Token 获取用户名
        String username= (String) authenticationToken.getPrincipal();
        System.out.println(username+"--------------------");
        //根据用户名从数据库中查询该用户
        SysUser user = sysUserService.selectByUserAccount(username);
        if(user == null){
            throw new UnknownAccountException("用户名或密码错误");
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getPhone(),user.getUserPwd(),getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(CustomParamConfig.getSalt()));
        System.out.println(user.getUserPwd());
        Session session=SecurityUtils.getSubject().getSession();
        session.setAttribute("user",user);
        return simpleAuthenticationInfo;
    }
    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

    public static void main(String args[]) {
        System.out.println("Hello World!-----------------"+"--"+ConfigConstant.getSessionExpireTime());
        System.out.println("Hello World!-----------------"+ConfigConstant.getPasswordSlat()+"--"+ConfigConstant.getSessionExpireTime());
        System.out.println("Hello World!-----------------"+ ConfigConstant.getScancodeIOTComponentUrl() +"--"+ConfigConstant.getSessionExpireTime());
    }


}

package com.tools.common.shiro;

import com.tools.common.util.RedisUtil;
import com.tools.common.util.ShiroUtils;
import com.tools.module.sys.entity.SysUser;
import com.tools.module.sys.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

/**
 * 用户认证
 * 爪哇笔记：https://blog.52itstyle.vip
 * @author 小柒2012.zhang
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService userService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = ShiroUtils.getUserId();
        SimpleAuthorizationInfo info = (SimpleAuthorizationInfo) redisUtil.get("authInfo");
        if(info==null){
            List<String> rolesSet = userService.listUserRoles(userId);
            List<String> permsSet = userService.listUserPerms(userId);
            info = new SimpleAuthorizationInfo();
            info.setRoles(new HashSet<>(rolesSet));
            info.setStringPermissions(new HashSet<>(permsSet));
            redisUtil.set("authInfo",info);
        }
        return info;
    }

    /**
     * 获取认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        SysUser user = userService.getUser(username);
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }
        if(!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("密码不正确");
        }
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}


package com.hengxc.shiro.common.authentication;

import com.hengxc.shiro.common.annotation.Helper;
import org.apache.shiro.authz.AuthorizationInfo;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/30 18:15
 */
@Helper
public class ShiroHelper extends ShiroRealm {

    /**
     * 获取当前用户的角色和权限集合
     *
     * @return AuthorizationInfo
     */
    public AuthorizationInfo getCurrentuserAuthorizationInfo() {
        return super.doGetAuthorizationInfo(null);
    }
}

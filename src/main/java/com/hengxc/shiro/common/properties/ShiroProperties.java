package com.hengxc.shiro.common.properties;

import lombok.Data;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/30 18:12
 */
@Data
public class ShiroProperties {

    private long sessionTimeout;
    private int cookieTimeout;
    private String anonUrl;
    private String loginUrl;
    private String successUrl;
    private String logoutUrl;
    private String unauthorizedUrl;
}

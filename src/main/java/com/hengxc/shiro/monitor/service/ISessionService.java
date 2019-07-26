package com.hengxc.shiro.monitor.service;

import com.hengxc.shiro.monitor.entity.ActiveUser;

import java.util.List;

/**
 * @author chenguangxu
 * @date 2019/7/26 10:13
 */
public interface ISessionService {

    /**
     * 获取在线用户列表
     *
     * @param username 用户名
     * @return List<ActiveUser>
     * @author chenguangxu
     * @date 2019/7/26 10:13
     */
    List<ActiveUser> list(String username);

    /**
     * 踢出用户
     *
     * @param sessionId sessionId
     * @return
     * @author chenguangxu
     * @date 2019/7/26 10:13
     */
    void forceLogout(String sessionId);
}

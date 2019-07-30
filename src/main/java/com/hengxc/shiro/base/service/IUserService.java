package com.hengxc.shiro.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hengxc.shiro.base.entity.User;
import com.hengxc.shiro.common.entity.QueryRequest;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-25
 */
public interface IUserService extends IService<User> {

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return User
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:31
     */
    User findByName(String username);

    /**
     * 查找用户详细信息
     *
     * @param user
     * @param request
     * @return IPage<User>
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:30
     */
    IPage<User> findUserDetail(User user, QueryRequest request);

    /**
     * 通过用户名查找用户详细信息
     *
     * @param username
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:30
     */
    User findUserDetail(String username);

    /**
     * 更新用户登录时间
     *
     * @param username
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:30
     */
    void updateLoginTime(String username);

    /**
     * 新增用户
     *
     * @param user
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:30
     */
    void createUser(User user);

    /**
     * 删除用户
     *
     * @param userIds
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:29
     */
    void deleteUsers(String[] userIds);

    /**
     * 修改用户
     *
     * @param user
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:29
     */
    void updateUser(User user);

    /**
     * 重置密码
     *
     * @param usernames
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:29
     */
    void resetPassword(String[] usernames);

    /**
     * 注册用户
     *
     * @param username
     * @param password
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:29
     */
    void regist(String username, String password);

    /**
     * 修改密码
     *
     * @param username
     * @param password
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:28
     */
    void updatePassword(String username, String password);

    /**
     * 更新用户头像
     *
     * @param username
     * @param avatar
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:28
     */
    void updateAvatar(String username, String avatar);

    /**
     * 修改用户系统配置 个性化配置
     *
     * @param username 用户名称
     * @param theme    主题风格
     * @param isTab    是否开启 tab
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:27
     */
    void updateTheme(String username, String theme, String isTab);

    /**
     * 更新个人信息
     *
     * @param user
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:27
     */
    void updateProfile(User user);

}

package com.hengxc.shiro.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hengxc.shiro.base.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-25
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 通过角色id 删除
     *
     * @param roleIds
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:37
     */
    void deleteUserRolesByRoleId(List<String> roleIds);

    /**
     * 通过用户id 删除
     *
     * @param userIds
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:37
     */
    void deleteUserRolesByUserId(List<String> userIds);

}

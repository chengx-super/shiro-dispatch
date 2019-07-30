package com.hengxc.shiro.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hengxc.shiro.base.entity.Role;
import com.hengxc.shiro.common.entity.QueryRequest;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-25
 */
public interface IRoleService extends IService<Role> {

    /**
     * 通过用户名查找用户角色
     *
     * @param username
     * @return 用户角色集合
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:32
     */
    List<Role> findUserRole(String username);

    /**
     * 查找所有角色
     *
     * @param role
     * @return 角色集合
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:33
     */
    List<Role> findRoles(Role role);

    /**
     * 查找所有角色 分页
     *
     * @param role
     * @param request
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:33
     */
    IPage<Role> findRoles(Role role, QueryRequest request);

    /**
     * 通过角色名称查找相应的角色
     *
     * @param roleName
     * @return 角色
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:34
     */
    Role findByName(String roleName);

    /**
     * 新增角色
     *
     * @param role
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:34
     */
    void createRole(Role role);

    /**
     * 修改角色
     *
     * @param role
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:35
     */
    void updateRole(Role role);

    /**
     * 删除角色
     *
     * @param roleIds
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/25 18:35
     */
    void deleteRoles(String roleIds);

}

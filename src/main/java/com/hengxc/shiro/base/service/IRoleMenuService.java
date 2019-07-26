package com.hengxc.shiro.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hengxc.shiro.base.entity.RoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单关联表 服务类
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface IRoleMenuService extends IService<RoleMenu> {

    /**
     * 通过角色id 删除
     *
     * @param roleIds
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:36
     */
    void deleteRoleMenusByRoleId(List<String> roleIds);

    /**
     * 通过菜单id 删除
     *
     * @param menuIds
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:36
     */
    void deleteRoleMenusByMenuId(List<String> menuIds);

    /**
     * 递归删除菜单/按钮
     *
     * @param menuId
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:37
     */
    void deleteRoleMenus(String menuId);

}

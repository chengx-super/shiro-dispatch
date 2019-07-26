package com.hengxc.shiro.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hengxc.shiro.base.entity.Menu;
import com.hengxc.shiro.common.entity.MenuTree;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 查找用户权限集
     *
     * @param username 用户名
     * @return List<Menu> 用户权限集合
     * @author chenguangxu
     * @date 2019/7/25 18:18
     */
    List<Menu> findUserPermissions(String username);

    /**
     * 查找用户菜单集合
     *
     * @param username
     * @return 用户菜单集合
     * @author chenguangxu
     * @date 2019/7/25 18:20
     */
    MenuTree<Menu> findUserMenus(String username);

    /**
     * 查找所有菜单/按钮 树形
     *
     * @param menu
     * @return MenuTree<Menu>
     * @author chenguangxu
     * @date 2019/7/25 18:20
     */
    MenuTree<Menu> findMenus(Menu menu);

    /**
     * 查找所有菜单/按钮
     *
     * @param menu
     * @return List<Menu>
     * @author chenguangxu
     * @date 2019/7/25 18:21
     */
    List<Menu> findMenuList(Menu menu);

    /**
     * 新增菜单/按钮
     *
     * @param menu
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:21
     */
    void createMenu(Menu menu);

    /**
     * 更新菜单/按钮
     *
     * @param menu
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:22
     */
    void updateMenu(Menu menu);

    /**
     * 删除菜单/按钮
     *
     * @param menuIds
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:22
     */
    void deleteMeuns(String menuIds);

}

package com.hengxc.shiro.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hengxc.shiro.base.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查找用户权限集
     *
     * @param username 用户名
     * @return List<Menu> 权限集合
     * @author chenguangxu
     * @date 2019/7/25 18:02
     */
    List<Menu> findUserPermissions(String username);

    /**
     * 查找用户菜单集合
     *
     * @param username 用户名
     * @return List<Menu> 菜单集合
     * @author chenguangxu
     * @date 2019/7/25 18:02
     */
    List<Menu> findUserMenus(String username);

    /**
     * 通过父 id 查询所有菜单/按钮
     *
     * @param parentId
     * @return id 集合
     * @author chenguangxu
     * @date 2019/7/26 13:38
     */
    List<Long> findMenuIdByParentId(Long parentId);

    /**
     * 删除菜单/按钮 by deptId
     *
     * @param deptId id
     * @return
     * @author chenguangxu
     * @date 2019/7/26 11:42
     */
    void deleteByMenuId(Long deptId);


}

package com.hengxc.shiro.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hengxc.shiro.base.entity.RoleMenu;

/**
 * <p>
 * 角色菜单关联表 Mapper 接口
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 递归删除菜单/按钮
     *
     * @param menuId
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:05
     */
    void deleteRoleMenus(String menuId);


}

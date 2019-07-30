package com.hengxc.shiro.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hengxc.shiro.base.entity.Menu;
import com.hengxc.shiro.base.mapper.MenuMapper;
import com.hengxc.shiro.base.mapper.RoleMenuMapper;
import com.hengxc.shiro.base.service.IMenuService;
import com.hengxc.shiro.common.authentication.ShiroRealm;
import com.hengxc.shiro.common.entity.MenuTree;
import com.hengxc.shiro.common.utils.TreeUtil;
import com.hengxc.shiro.common.utils.snowFlake.SnowFlake;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-25
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    SnowFlake snowFlake = new SnowFlake(1, 1);

    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private ShiroRealm shiroRealm;

    @Override
    public List<Menu> findUserPermissions(String username) {
        return this.baseMapper.findUserPermissions(username);
    }

    @Override
    public MenuTree<Menu> findUserMenus(String username) {
        List<Menu> menus = this.baseMapper.findUserMenus(username);
        List<MenuTree<Menu>> trees = this.convertMenus(menus);
        return TreeUtil.buildMenuTree(trees);
    }

    @Override
    public MenuTree<Menu> findMenus(Menu menu) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(menu.getMenuName())) {
            queryWrapper.lambda().like(Menu::getMenuName, menu.getMenuName());
        }
        queryWrapper.lambda().orderByAsc(Menu::getOrderNum);
        List<Menu> menus = this.baseMapper.selectList(queryWrapper);
        List<MenuTree<Menu>> trees = this.convertMenus(menus);

        return TreeUtil.buildMenuTree(trees);
    }

    @Override
    public List<Menu> findMenuList(Menu menu) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(menu.getMenuName())) {
            queryWrapper.lambda().like(Menu::getMenuName, menu.getMenuName());
        }
        queryWrapper.lambda().orderByAsc(Menu::getMenuId).orderByAsc(Menu::getOrderNum);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createMenu(Menu menu) {
        if (menu.getMenuId() == null) {
            menu.setMenuId(snowFlake.nextId());
        }
        menu.setCreateTime(Instant.now().toEpochMilli());
        this.setMenu(menu);
        this.baseMapper.insert(menu);
    }


    @Override
    @Transactional
    public void updateMenu(Menu menu) {
        menu.setModifyTime(Instant.now().toEpochMilli());
        this.setMenu(menu);
        this.baseMapper.updateById(menu);

        shiroRealm.clearCache();
    }

    @Override
    @Transactional
    public void deleteMeuns(List<Long> menuIds) {
        menuIds.forEach(menuId -> {
            //删除 菜单/按钮
            this.baseMapper.deleteByMenuId(menuId);
            //递归删除子 菜单/按钮
            this.deleteMeunById(menuId);
        });

        shiroRealm.clearCache();
    }

    //递归删除 菜单/按钮
    public void deleteMeunById(Long deptIds) {
        List<Long> ids = this.baseMapper.findMenuIdByParentId(deptIds);
        if (ids.size() > 0) {
            ids.forEach(deptId -> {
                //删除 菜单/按钮
                this.baseMapper.deleteByMenuId(deptId);
                deleteMeunById(deptId);
            });
        }
    }

    private List<MenuTree<Menu>> convertMenus(List<Menu> menus) {
        List<MenuTree<Menu>> trees = new ArrayList<>();
        menus.forEach(menu -> {
            MenuTree<Menu> tree = new MenuTree<>();
            tree.setId(String.valueOf(menu.getMenuId()));
            tree.setParentId(String.valueOf(menu.getParentId()));
            tree.setTitle(menu.getMenuName());
            tree.setIcon(menu.getIcon());
            tree.setHref(menu.getUrl());
            tree.setData(menu);
            trees.add(tree);
        });
        return trees;
    }

    private void setMenu(Menu menu) {
        if (menu.getParentId() == null)
            menu.setParentId(Menu.TOP_NODE);
        if (Menu.TYPE_BUTTON.equals(menu.getType())) {
            menu.setUrl(null);
            menu.setIcon(null);
        }
    }

}

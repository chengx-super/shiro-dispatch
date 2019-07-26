package com.hengxc.shiro.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hengxc.shiro.base.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 通过用户名查找角色
     *
     * @param username
     * @return List<Role>
     * @author chenguangxu
     * @date 2019/7/25 18:03
     */
    List<Role> findUserRole(String username);


    /**
     * 查找角色详情
     *
     * @param page 分页
     * @param role 角色
     * @return IPage<Role>
     * @author chenguangxu
     * @date 2019/7/25 18:04
     */
    IPage<Role> findRolePage(Page page, @Param("role") Role role);

}

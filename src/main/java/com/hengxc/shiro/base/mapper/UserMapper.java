package com.hengxc.shiro.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hengxc.shiro.base.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户名查找用户名
     *
     * @param username 用户名
     * @return User
     * @author chenguangxu
     * @date 2019/7/25 18:05
     */
    User findByName(String username);

    /**
     * 查找用户详情
     *
     * @param page 分页对象
     * @param user 用户对象，用于传递查询条件
     * @return IPage<User>
     * @author chenguangxu
     * @date 2019/7/25 18:06
     */
    IPage<User> findUserDetailPage(Page page, @Param("user") User user);

    /**
     * 查找用户详细信息
     *
     * @param user 用户对象
     * @return List<User>
     * @author chenguangxu
     * @date 2019/7/25 18:06
     */
    List<User> findUserDetail(@Param("user") User user);

}

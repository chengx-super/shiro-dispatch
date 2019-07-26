package com.hengxc.shiro.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hengxc.shiro.base.entity.Dept;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface DeptMapper extends BaseMapper<Dept> {


    /**
     * 通过父 id 查询所有部门
     *
     * @param parentId
     * @return 部门id 集合
     * @author chenguangxu
     * @date 2019/7/26 13:38
     */
    List<Long> findDeptIdByParentId(Long parentId);

    /**
     * 删除部门 by deptId
     *
     * @param deptId 部门id
     * @return
     * @author chenguangxu
     * @date 2019/7/26 11:42
     */
    void deleteByDeptId(Long deptId);

}

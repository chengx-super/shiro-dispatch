package com.hengxc.shiro.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hengxc.shiro.base.entity.Dept;

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
     * 递归删除部门
     *
     * @param deptId
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:01
     */
    void deleteDepts(String deptId);

}

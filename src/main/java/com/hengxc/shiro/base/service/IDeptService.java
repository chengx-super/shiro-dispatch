package com.hengxc.shiro.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hengxc.shiro.base.entity.Dept;
import com.hengxc.shiro.common.entity.DeptTree;
import com.hengxc.shiro.common.entity.QueryRequest;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface IDeptService extends IService<Dept> {

    /**
     * 获取部门树 下拉选择使用
     *
     * @param
     * @return List<DeptTree < Dept>> 部门树集合
     * @author chenguangxu
     * @date 2019/7/25 18:12
     */
    List<DeptTree<Dept>> findDepts();

    /**
     * 获取部门列表 树形列表
     *
     * @param dept 部门对象
     * @return List<DeptTree < Dept>>
     * @author chenguangxu
     * @date 2019/7/25 18:13
     */
    List<DeptTree<Dept>> findDepts(Dept dept);

    /**
     * 获取部门树
     *
     * @param dept    部门对象
     * @param request
     * @return List<Dept>
     * @author chenguangxu
     * @date 2019/7/25 18:14
     */
    List<Dept> findDepts(Dept dept, QueryRequest request);

    /**
     * 新增部门
     *
     * @param dept 部门对象
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:15
     */
    void createDept(Dept dept);

    /**
     * 修改部门
     *
     * @param dept 部门对象
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:15
     */
    void updateDept(Dept dept);

    /**
     * 删除部门
     *
     * @param deptIds 部门id 集合
     * @return
     * @author chenguangxu
     * @date 2019/7/25 18:15
     */
    void deleteDepts(List<Long> deptIds);

}

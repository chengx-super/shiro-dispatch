package com.hengxc.shiro.base.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.hengxc.shiro.base.entity.Dept;
import com.hengxc.shiro.base.service.IDeptService;
import com.hengxc.shiro.common.annotation.Log;
import com.hengxc.shiro.common.entity.DeptTree;
import com.hengxc.shiro.common.entity.FebsResponse;
import com.hengxc.shiro.common.exception.FebsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Slf4j
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @GetMapping("select/tree")
    public List<DeptTree<Dept>> getDeptTree() throws FebsException {
        try {
            return this.deptService.findDepts();
        } catch (Exception e) {
            String message = "获取部门树失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @GetMapping("tree")
    public FebsResponse getDeptTree(Dept dept) throws FebsException {
        try {
            List<DeptTree<Dept>> depts = this.deptService.findDepts(dept);
            return new FebsResponse().success().data(depts);
        } catch (Exception e) {
            String message = "获取部门树失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("新增部门")
    @PostMapping
    @RequiresPermissions("dept:add")
    public FebsResponse addDept(@Valid Dept dept) throws FebsException {
        try {
            this.deptService.createDept(dept);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "新增部门失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("删除部门")
    @GetMapping("delete/{deptIds}")
    @RequiresPermissions("dept:delete")
    public FebsResponse deleteDepts(@NotBlank(message = "{required}") @PathVariable String deptIds) throws FebsException {
        try {
            String[] ids = deptIds.split(StringPool.COMMA);
            this.deptService.deleteDepts(ids);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "删除部门失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("修改部门")
    @PostMapping("update")
    @RequiresPermissions("dept:update")
    public FebsResponse updateDept(@Valid Dept dept) throws FebsException {
        try {
            this.deptService.updateDept(dept);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "修改部门失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}

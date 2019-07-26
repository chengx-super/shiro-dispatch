package com.hengxc.shiro.base.controller;


import com.hengxc.shiro.base.entity.Role;
import com.hengxc.shiro.base.service.IRoleService;
import com.hengxc.shiro.common.annotation.Log;
import com.hengxc.shiro.common.controller.BaseController;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.common.entity.Response;
import com.hengxc.shiro.common.exception.FebsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Slf4j
@RestController
@RequestMapping("role")
public class RoleController extends BaseController {


    @Autowired
    private IRoleService roleService;

    @GetMapping
    public Response getAllRoles(Role role) {
        return new Response().success().data(roleService.findRoles(role));
    }

    @GetMapping("list")
    @RequiresPermissions("role:view")
    public Response roleList(Role role, QueryRequest request) {
        Map<String, Object> dataTable = getDataTable(this.roleService.findRoles(role, request));
        return new Response().success().data(dataTable);
    }

    @Log("新增角色")
    @PostMapping
    @RequiresPermissions("role:add")
    public Response addRole(@Valid Role role) throws FebsException {
        try {
            this.roleService.createRole(role);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "新增角色失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("删除角色")
    @GetMapping("delete/{roleIds}")
    @RequiresPermissions("role:delete")
    public Response deleteRoles(@NotBlank(message = "{required}") @PathVariable String roleIds) throws FebsException {
        try {
            this.roleService.deleteRoles(roleIds);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "删除角色失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("修改角色")
    @PostMapping("update")
    @RequiresPermissions("role:update")
    public Response updateRole(Role role) throws FebsException {
        try {
            this.roleService.updateRole(role);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "修改角色失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}

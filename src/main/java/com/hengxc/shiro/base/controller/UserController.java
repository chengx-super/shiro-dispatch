package com.hengxc.shiro.base.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.hengxc.shiro.base.entity.User;
import com.hengxc.shiro.base.service.IUserService;
import com.hengxc.shiro.common.annotation.Log;
import com.hengxc.shiro.common.controller.BaseController;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.common.entity.Response;
import com.hengxc.shiro.common.exception.FebsException;
import com.hengxc.shiro.common.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping("{username}")
    public User getUser(@NotBlank(message = "{required}") @PathVariable String username) {
        return this.userService.findUserDetail(username);
    }

    @GetMapping("check/{username}")
    public boolean checkUserName(@NotBlank(message = "{required}") @PathVariable String username, String userId) {
        return this.userService.findByName(username) == null || StringUtils.isNotBlank(userId);
    }

    @GetMapping("list")
    @RequiresPermissions("user:view")
    public Response userList(User user, QueryRequest request) {
        Map<String, Object> dataTable = getDataTable(this.userService.findUserDetail(user, request));
        return new Response().success().data(dataTable);
    }

    @Log("新增用户")
    @PostMapping
    @RequiresPermissions("user:add")
    public Response addUser(@Valid User user) throws FebsException {
        try {
            this.userService.createUser(user);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("删除用户")
    @GetMapping("delete/{userIds}")
    @RequiresPermissions("user:delete")
    public Response deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) throws FebsException {
        try {
            String[] ids = userIds.split(StringPool.COMMA);
            this.userService.deleteUsers(ids);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "删除用户失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("修改用户")
    @PostMapping("update")
    @RequiresPermissions("user:update")
    public Response updateUser(@Valid User user) throws FebsException {
        try {
            if (user.getUserId() == null)
                throw new FebsException("用户ID为空");
            this.userService.updateUser(user);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "修改用户失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PostMapping("password/reset/{usernames}")
    @RequiresPermissions("user:password:reset")
    public Response resetPassword(@NotBlank(message = "{required}") @PathVariable String usernames) throws FebsException {
        try {
            String[] usernameArr = usernames.split(StringPool.COMMA);
            this.userService.resetPassword(usernameArr);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "重置用户密码失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PostMapping("password/update")
    public Response updatePassword(
            @NotBlank(message = "{required}") String oldPassword,
            @NotBlank(message = "{required}") String newPassword) throws FebsException {
        try {
            User user = getCurrentUser();
            if (!StringUtils.equals(user.getPassword(), MD5Util.encrypt(user.getUsername(), oldPassword))) {
                throw new FebsException("原密码不正确");
            }
            userService.updatePassword(user.getUsername(), newPassword);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "修改密码失败，" + e.getMessage();
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @GetMapping("avatar/{image}")
    public Response updateAvatar(@NotBlank(message = "{required}") @PathVariable String image) throws FebsException {
        try {
            User user = getCurrentUser();
            this.userService.updateAvatar(user.getUsername(), image);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "修改头像失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PostMapping("theme/update")
    public Response updateTheme(String theme, String isTab) throws FebsException {
        try {
            User user = getCurrentUser();
            this.userService.updateTheme(user.getUsername(), theme, isTab);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "修改系统配置失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PostMapping("profile/update")
    public Response updateProfile(User user) throws FebsException {
        try {
            User currentUser = getCurrentUser();
            user.setUserId(currentUser.getUserId());
            this.userService.updateProfile(user);
            return new Response().success();
        } catch (java.lang.Exception e) {
            String message = "修改个人信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}

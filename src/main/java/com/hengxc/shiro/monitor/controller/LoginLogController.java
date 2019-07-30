package com.hengxc.shiro.monitor.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.hengxc.shiro.common.controller.BaseController;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.common.entity.Response;
import com.hengxc.shiro.common.exception.FebsException;
import com.hengxc.shiro.monitor.entity.LoginLog;
import com.hengxc.shiro.monitor.service.ILoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * <p>
 * 登录日志表 前端控制器
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-26
 */
@Slf4j
@RestController
@RequestMapping("loginLog")
public class LoginLogController extends BaseController {

    @Autowired
    private ILoginLogService loginLogService;

    @GetMapping("list")
    @RequiresPermissions("loginlog:view")
    public Response loginLogList(LoginLog loginLog, QueryRequest request) {
        Map<String, Object> dataTable = getDataTable(this.loginLogService.findLoginLogs(loginLog, request));
        return new Response().success().data(dataTable);
    }

    @GetMapping("delete/{ids}")
    @RequiresPermissions("loginlog:delete")
    public Response deleteLogss(@NotBlank(message = "{required}") @PathVariable String ids) throws FebsException {
        try {
            String[] loginLogIds = ids.split(StringPool.COMMA);
            this.loginLogService.deleteLoginLogs(loginLogIds);
            return new Response().success();
        } catch (Exception e) {
            String message = "删除日志失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}

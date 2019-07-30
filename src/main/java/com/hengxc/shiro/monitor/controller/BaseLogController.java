package com.hengxc.shiro.monitor.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.hengxc.shiro.common.controller.BaseController;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.common.entity.Response;
import com.hengxc.shiro.common.exception.FebsException;
import com.hengxc.shiro.monitor.entity.BaseLog;
import com.hengxc.shiro.monitor.service.IBaseLogService;
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
 * 操作日志表 前端控制器
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-26
 */
@Slf4j
@RestController
@RequestMapping("log")
public class BaseLogController extends BaseController {

    @Autowired
    private IBaseLogService baseLogService;

    @GetMapping("list")
    @RequiresPermissions("log:view")
    public Response logList(BaseLog baseLog, QueryRequest request) {
        Map<String, Object> dataTable = getDataTable(this.baseLogService.findBaseLogs(baseLog, request));
        return new Response().success().data(dataTable);
    }

    @GetMapping("delete/{ids}")
    @RequiresPermissions("log:delete")
    public Response deleteLogss(@NotBlank(message = "{required}") @PathVariable String ids) throws FebsException {
        try {
            String[] logIds = ids.split(StringPool.COMMA);
            this.baseLogService.deleteBaseLogs(logIds);
            return new Response().success();
        } catch (Exception e) {
            String message = "删除日志失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}

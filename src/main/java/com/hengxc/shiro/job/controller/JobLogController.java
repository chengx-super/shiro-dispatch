package com.hengxc.shiro.job.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.hengxc.shiro.common.controller.BaseController;
import com.hengxc.shiro.common.entity.FebsResponse;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.common.exception.FebsException;
import com.hengxc.shiro.job.entity.JobLog;
import com.hengxc.shiro.job.service.IJobLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * <p>
 * 调度日志表 前端控制器
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/jobLog")
public class JobLogController extends BaseController {

    @Autowired
    private IJobLogService jobLogService;

    @GetMapping
    @RequiresPermissions("job:log:view")
    public FebsResponse jobLogList(QueryRequest request, JobLog log) {
        Map<String, Object> dataTable = getDataTable(this.jobLogService.findJobLogs(request, log));
        return new FebsResponse().success().data(dataTable);
    }

    @GetMapping("delete/{jobIds}")
    @RequiresPermissions("job:log:delete")
    public FebsResponse deleteJobLog(@NotBlank(message = "{required}") @PathVariable String jobIds) throws FebsException {
        try {
            String[] ids = jobIds.split(StringPool.COMMA);
            this.jobLogService.deleteJobLogs(ids);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "删除调度日志失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}

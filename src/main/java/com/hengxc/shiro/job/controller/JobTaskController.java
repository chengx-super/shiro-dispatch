package com.hengxc.shiro.job.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.hengxc.shiro.common.annotation.Log;
import com.hengxc.shiro.common.controller.BaseController;
import com.hengxc.shiro.common.entity.FebsResponse;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.common.exception.FebsException;
import com.hengxc.shiro.job.entity.JobTask;
import com.hengxc.shiro.job.service.IJobTaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 定时任务表 前端控制器
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/job")
public class JobTaskController extends BaseController {

    @Autowired
    private IJobTaskService jobTaskService;


    @GetMapping
    @RequiresPermissions("job:view")
    public FebsResponse jobList(QueryRequest request, JobTask job) {
        Map<String, Object> dataTable = getDataTable(this.jobTaskService.findJobTasks(request, job));
        return new FebsResponse().success().data(dataTable);
    }

    @GetMapping("cron/check")
    public boolean checkCron(String cron) {
        try {
            return CronExpression.isValidExpression(cron);
        } catch (Exception e) {
            return false;
        }
    }

    @Log("新增定时任务")
    @PostMapping
    @RequiresPermissions("job:add")
    public FebsResponse addJob(@Valid JobTask job) throws FebsException {
        try {
            this.jobTaskService.createJobTask(job);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "新增定时任务失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("删除定时任务")
    @GetMapping("delete/{jobIds}")
    @RequiresPermissions("job:delete")
    public FebsResponse deleteJob(@NotBlank(message = "{required}") @PathVariable String jobIds) throws FebsException {
        try {
            String[] ids = jobIds.split(StringPool.COMMA);
            this.jobTaskService.deleteJobTasks(ids);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "删除定时任务失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("修改定时任务")
    @PostMapping("update")
    public FebsResponse updateJob(@Valid JobTask job) throws FebsException {
        try {
            this.jobTaskService.updateJobTask(job);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "修改定时任务失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("执行定时任务")
    @RequiresPermissions("job:run")
    @GetMapping("run/{jobIds}")
    public FebsResponse runJob(@NotBlank(message = "{required}") @PathVariable String jobIds) throws FebsException {
        try {
            this.jobTaskService.run(jobIds);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "执行定时任务失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("暂停定时任务")
    @GetMapping("pause/{jobIds}")
    @RequiresPermissions("job:pause")
    public FebsResponse pauseJob(@NotBlank(message = "{required}") @PathVariable String jobIds) throws FebsException {
        try {
            this.jobTaskService.pause(jobIds);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "暂停定时任务失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("恢复定时任务")
    @GetMapping("resume/{jobIds}")
    @RequiresPermissions("job:resume")
    public FebsResponse resumeJob(@NotBlank(message = "{required}") @PathVariable String jobIds) throws FebsException {
        try {
            this.jobTaskService.resume(jobIds);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "恢复定时任务失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}

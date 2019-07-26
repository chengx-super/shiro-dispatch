package com.hengxc.shiro.job.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hengxc.shiro.common.entity.Constant;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.common.utils.SortUtil;
import com.hengxc.shiro.common.utils.snowFlake.SnowFlake;
import com.hengxc.shiro.job.entity.JobTask;
import com.hengxc.shiro.job.mapper.JobTaskMapper;
import com.hengxc.shiro.job.service.IJobTaskService;
import com.hengxc.shiro.job.util.ScheduleUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 定时任务表 服务实现类
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
@Service
public class JobTaskServiceImpl extends ServiceImpl<JobTaskMapper, JobTask> implements IJobTaskService {

    SnowFlake snowFlake = new SnowFlake(1, 1);

    @Resource
    private Scheduler scheduler;


    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        List<JobTask> scheduleJobTaskList = this.baseMapper.queryList();
        // 如果不存在，则创建
        scheduleJobTaskList.forEach(scheduleJobTask -> {
            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJobTask.getJobId());
            if (cronTrigger == null) {
                ScheduleUtils.createScheduleJobTask(scheduler, scheduleJobTask);
            } else {
                ScheduleUtils.updateScheduleJobTask(scheduler, scheduleJobTask);
            }
        });
    }

    @Override
    public JobTask findJobTask(Long jobId) {
        return this.getById(jobId);
    }

    @Override
    public IPage<JobTask> findJobTasks(QueryRequest request, JobTask job) {
        LambdaQueryWrapper<JobTask> queryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(job.getBeanName())) {
            queryWrapper.eq(JobTask::getBeanName, job.getBeanName());
        }
        if (StringUtils.isNotBlank(job.getMethodName())) {
            queryWrapper.eq(JobTask::getMethodName, job.getMethodName());
        }
        if (StringUtils.isNotBlank(job.getParams())) {
            queryWrapper.like(JobTask::getParams, job.getParams());
        }
        if (StringUtils.isNotBlank(job.getRemark())) {
            queryWrapper.like(JobTask::getRemark, job.getRemark());
        }
        if (StringUtils.isNotBlank(job.getStatus())) {
            queryWrapper.eq(JobTask::getStatus, job.getStatus());
        }

        if (StringUtils.isNotBlank(job.getCreateTimeFrom()) && StringUtils.isNotBlank(job.getCreateTimeTo())) {
            queryWrapper
                    .ge(JobTask::getCreateTime, job.getCreateTimeFrom())
                    .le(JobTask::getCreateTime, job.getCreateTimeTo());
        }
        Page<JobTask> page = new Page<>(request.getPageNum(), request.getPageSize());
        SortUtil.handlePageSort(request, page, "createTime", Constant.ORDER_DESC, true);
        return this.page(page, queryWrapper);
    }

    @Override
    @Transactional
    public void createJobTask(JobTask job) {
        if (job.getJobId() == null) {
            job.setJobId(snowFlake.nextId());
        }
        job.setCreateTime(Instant.now().toEpochMilli());
        job.setStatus(JobTask.ScheduleStatus.PAUSE.getValue());
        this.save(job);
        ScheduleUtils.createScheduleJobTask(scheduler, job);
    }

    @Override
    @Transactional
    public void updateJobTask(JobTask job) {
        ScheduleUtils.updateScheduleJobTask(scheduler, job);
        this.baseMapper.updateById(job);
    }

    @Override
    @Transactional
    public void deleteJobTasks(String[] jobIds) {
        List<String> list = Arrays.asList(jobIds);
        list.forEach(jobId -> ScheduleUtils.deleteScheduleJobTask(scheduler, Long.valueOf(jobId)));
        this.baseMapper.deleteBatchIds(list);
    }

    @Override
    @Transactional
    public int updateBatch(String jobIds, String status) {
        List<String> list = Arrays.asList(jobIds.split(StringPool.COMMA));
        JobTask job = new JobTask();
        job.setStatus(status);
        return this.baseMapper.update(job, new LambdaQueryWrapper<JobTask>().in(JobTask::getJobId, list));
    }

    @Override
    @Transactional
    public void run(String jobIds) {
        String[] list = jobIds.split(StringPool.COMMA);
        Arrays.stream(list).forEach(jobId -> ScheduleUtils.run(scheduler, this.findJobTask(Long.valueOf(jobId))));
    }

    @Override
    @Transactional
    public void pause(String jobIds) {
        String[] list = jobIds.split(StringPool.COMMA);
        Arrays.stream(list).forEach(jobId -> ScheduleUtils.pauseJobTask(scheduler, Long.valueOf(jobId)));
        this.updateBatch(jobIds, JobTask.ScheduleStatus.PAUSE.getValue());
    }

    @Override
    @Transactional
    public void resume(String jobIds) {
        String[] list = jobIds.split(StringPool.COMMA);
        Arrays.stream(list).forEach(jobId -> ScheduleUtils.resumeJobTask(scheduler, Long.valueOf(jobId)));
        this.updateBatch(jobIds, JobTask.ScheduleStatus.NORMAL.getValue());
    }


}

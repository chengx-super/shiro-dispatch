package com.hengxc.shiro.job.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.job.entity.JobTask;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 定时任务表 服务类
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface IJobTaskService extends IService<JobTask> {

    JobTask findJobTask(Long jobId);

    IPage<JobTask> findJobTasks(QueryRequest request, JobTask job);

    void createJobTask(JobTask job);

    void updateJobTask(JobTask job);

    void deleteJobTasks(String[] jobIds);

    int updateBatch(String jobIds, String status);

    void run(String jobIds);

    void pause(String jobIds);

    void resume(String jobIds);

}

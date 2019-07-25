package com.hengxc.shiro.job.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.job.entity.JobLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 调度日志表 服务类
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface IJobLogService extends IService<JobLog> {

    IPage<JobLog> findJobLogs(QueryRequest request, JobLog jobLog);

    void saveJobLog(JobLog log);

    void deleteJobLogs(String[] jobLogIds);

}

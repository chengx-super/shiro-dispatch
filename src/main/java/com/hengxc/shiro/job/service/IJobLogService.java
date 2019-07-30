package com.hengxc.shiro.job.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.job.entity.JobLog;

/**
 * <p>
 * 调度日志表 服务类
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-25
 */
public interface IJobLogService extends IService<JobLog> {

    IPage<JobLog> findJobLogs(QueryRequest request, JobLog jobLog);

    void saveJobLog(JobLog log);

    void deleteJobLogs(String[] jobLogIds);

}

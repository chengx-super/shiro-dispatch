package com.hengxc.shiro.job.mapper;

import com.hengxc.shiro.job.entity.JobTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 定时任务表 Mapper 接口
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
public interface JobTaskMapper extends BaseMapper<JobTask> {

    List<JobTask> queryList();

}

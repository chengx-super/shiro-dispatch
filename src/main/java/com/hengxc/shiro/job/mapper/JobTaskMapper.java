package com.hengxc.shiro.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hengxc.shiro.job.entity.JobTask;

import java.util.List;

/**
 * <p>
 * 定时任务表 Mapper 接口
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-25
 */
public interface JobTaskMapper extends BaseMapper<JobTask> {

    List<JobTask> queryList();

}

package com.hengxc.shiro.job.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 调度日志表
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Data
@TableName("t_job_task_log")
public class JobLog implements Serializable {

    // 任务执行成功
    public static final String JOB_SUCCESS = "0";
    // 任务执行失败
    public static final String JOB_FAIL = "1";
    private static final long serialVersionUID = 1L;
    /**
     * 任务日志id
     */
    @TableId("LOG_ID")
    private Long logId;

    /**
     * 任务id
     */
    @TableField("JOB_ID")
    private Long jobId;

    /**
     * spring bean名称
     */
    @TableField("BEAN_NAME")
    private String beanName;

    /**
     * 方法名
     */
    @TableField("METHOD_NAME")
    private String methodName;

    /**
     * 参数
     */
    @TableField("PARAMS")
    private String params;

    /**
     * 任务状态    0：成功    1：失败
     */
    @TableField("STATUS")
    private String status;

    /**
     * 失败信息
     */
    @TableField("ERROR")
    private String error;

    /**
     * 耗时(单位：毫秒)
     */
    @TableField("TIMES")
    private Long times;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Long createTime;

    private transient String createTimeFrom;
    private transient String createTimeTo;

}

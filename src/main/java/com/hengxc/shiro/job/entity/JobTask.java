package com.hengxc.shiro.job.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 定时任务表
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Data
@TableName("t_job_task")
public class JobTask implements Serializable {

    /**
     * 任务调度参数 key
     */
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";
    private static final long serialVersionUID = 1L;
    /**
     * 任务id
     */
    @TableId("JOB_ID")
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
     * cron表达式
     */
    @TableField("CRON_EXPRESSION")
    private String cronExpression;
    /**
     * 任务状态  0：正常  1：暂停
     */
    @TableField("STATUS")
    private String status;
    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Long createTime;
    private transient String createTimeFrom;
    private transient String createTimeTo;

    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL("0"),
        /**
         * 暂停
         */
        PAUSE("1");

        private String value;

        ScheduleStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


}

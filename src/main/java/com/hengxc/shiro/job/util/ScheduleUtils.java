package com.hengxc.shiro.job.util;

import com.hengxc.shiro.job.entity.JobTask;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

/**
 * 定时任务工具类
 *
 * @author MrBird
 */
@Slf4j
public class ScheduleUtils {

    protected ScheduleUtils() {

    }

    private static final String JOB_NAME_PREFIX = "TASK_";

    /**
     * 获取触发器 key
     */
    private static TriggerKey getTriggerKey(Long jobId) {
        return TriggerKey.triggerKey(JOB_NAME_PREFIX + jobId);
    }

    /**
     * 获取jobKey
     */
    private static JobKey getJobKey(Long jobId) {
        return JobKey.jobKey(JOB_NAME_PREFIX + jobId);
    }

    /**
     * 获取表达式触发器
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, Long jobId) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobId));
        } catch (SchedulerException e) {
            log.error("获取Cron表达式失败", e);
        }
        return null;
    }

    /**
     * 创建定时任务
     */
    public static void createScheduleJobTask(Scheduler scheduler, JobTask scheduleJob) {
        try {
            // 构建job信息
            JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class).withIdentity(getJobKey(scheduleJob.getJobId()))
                    .build();

            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(scheduleJob.getJobId()))
                    .withSchedule(scheduleBuilder).build();

            // 放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(JobTask.JOB_PARAM_KEY, scheduleJob);

            scheduler.scheduleJob(jobDetail, trigger);

            // 暂停任务
            if (scheduleJob.getStatus().equals(JobTask.ScheduleStatus.PAUSE.getValue())) {
                pauseJobTask(scheduler, scheduleJob.getJobId());
            }
        } catch (SchedulerException e) {
            log.error("创建定时任务失败", e);
        }
    }

    /**
     * 更新定时任务
     */
    public static void updateScheduleJobTask(Scheduler scheduler, JobTask scheduleJob) {
        try {
            TriggerKey triggerKey = getTriggerKey(scheduleJob.getJobId());

            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            CronTrigger trigger = getCronTrigger(scheduler, scheduleJob.getJobId());

            if (trigger == null) {
                throw new SchedulerException("获取Cron表达式失败");
            } else {
                // 按新的 cronExpression表达式重新构建 trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                // 参数
                trigger.getJobDataMap().put(JobTask.JOB_PARAM_KEY, scheduleJob);
            }

            scheduler.rescheduleJob(triggerKey, trigger);

            // 暂停任务
            if (scheduleJob.getStatus().equals(JobTask.ScheduleStatus.PAUSE.getValue())) {
                pauseJobTask(scheduler, scheduleJob.getJobId());
            }

        } catch (SchedulerException e) {
            log.error("更新定时任务失败", e);
        }
    }

    /**
     * 立即执行任务
     */
    public static void run(Scheduler scheduler, JobTask scheduleJob) {
        try {
            // 参数
            JobDataMap dataMap = new JobDataMap();
            dataMap.put(JobTask.JOB_PARAM_KEY, scheduleJob);

            scheduler.triggerJob(getJobKey(scheduleJob.getJobId()), dataMap);
        } catch (SchedulerException e) {
            log.error("执行定时任务失败", e);
        }
    }

    /**
     * 暂停任务
     */
    public static void pauseJobTask(Scheduler scheduler, Long jobId) {
        try {
            scheduler.pauseJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            log.error("暂停定时任务失败", e);
        }
    }

    /**
     * 恢复任务
     */
    public static void resumeJobTask(Scheduler scheduler, Long jobId) {
        try {
            scheduler.resumeJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            log.error("恢复定时任务失败", e);
        }
    }

    /**
     * 删除定时任务
     */
    public static void deleteScheduleJobTask(Scheduler scheduler, Long jobId) {
        try {
            scheduler.deleteJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            log.error("删除定时任务失败", e);
        }
    }
}

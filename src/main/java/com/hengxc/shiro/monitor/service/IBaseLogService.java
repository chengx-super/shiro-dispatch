package com.hengxc.shiro.monitor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.monitor.entity.BaseLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 * 操作日志表 服务类
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-26
 */
public interface IBaseLogService extends IService<BaseLog> {

    /**
     * 查询操作日志 分页
     *
     * @param baseLog
     * @param request
     * @return
     * @author chenguangxu
     * @date 2019/7/26 9:57
     */
    IPage<BaseLog> findBaseLogs(BaseLog baseLog, QueryRequest request);

    /**
     * 删除操作日志
     *
     * @param BaselogIds 日志id 集合
     * @return
     * @author chenguangxu
     * @date 2019/7/26 9:58
     */
    void deleteBaseLogs(String[] BaselogIds);

    /**
     * 异步保存操作日志
     *
     * @param point   切点
     * @param baseLog 日志
     * @return
     * @author chenguangxu
     * @date 2019/7/26 9:59
     */
    @Async("febsAsyncThreadPool")
    void saveLog(ProceedingJoinPoint point, BaseLog baseLog) throws JsonProcessingException;

}

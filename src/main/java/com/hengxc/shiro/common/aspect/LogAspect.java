package com.hengxc.shiro.common.aspect;

import com.hengxc.shiro.base.entity.User;
import com.hengxc.shiro.common.properties.Properties;
import com.hengxc.shiro.common.utils.HttpContextUtil;
import com.hengxc.shiro.common.utils.IPUtil;
import com.hengxc.shiro.monitor.entity.BaseLog;
import com.hengxc.shiro.monitor.service.IBaseLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP 记录用户操作日志
 *
 * @author MrBird
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private Properties properties;

    @Autowired
    private IBaseLogService baseLogService;

    @Pointcut("@annotation(com.hengxc.shiro.common.annotation.Log)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result;
        long beginTime = System.currentTimeMillis();
        // 执行方法
        result = point.proceed();
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        // 设置 IP地址
        String ip = IPUtil.getIpAddr(request);
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        if (properties.isOpenAopLog()) {
            // 保存日志
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            BaseLog log = new BaseLog();
            if (user != null)
                log.setUsername(user.getUsername());
            log.setIp(ip);
            log.setTime(time);
            baseLogService.saveLog(point, log);
        }
        return result;
    }
}

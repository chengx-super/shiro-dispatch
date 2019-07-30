package com.hengxc.shiro.common.runner;

import com.hengxc.shiro.common.properties.Properties;
import com.hengxc.shiro.monitor.service.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/30 18:12
 */
@Slf4j
@Component
public class StartedUpRunner implements ApplicationRunner {

    @Autowired
    private ConfigurableApplicationContext context;
    @Autowired
    private Properties properties;
    @Autowired
    private IRedisService redisService;

    @Value("${server.port:8080}")
    private String port;
    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // 测试 Redis连接是否正常
            redisService.exists("redis_test");
        } catch (Exception e) {
            log.info("                                                      ");
            log.error("启动失败，{}", e.getMessage());
            log.error("Redis连接异常，请检查Redis连接配置并确保Redis服务已启动");
            // 关闭
            context.close();
        }
        if (context.isActive()) {
            InetAddress address = InetAddress.getLocalHost();
            String url = String.format("http://%s:%s", address.getHostAddress(), port);
            String loginUrl = properties.getShiro().getLoginUrl();
            if (StringUtils.isNotBlank(contextPath))
                url += contextPath;
            if (StringUtils.isNotBlank(loginUrl))
                url += loginUrl;
            log.info("                                                      ");
            log.info(" 系统启动完毕，地址：{}", url);
        }
    }
}

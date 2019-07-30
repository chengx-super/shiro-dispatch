package com.hengxc.shiro.common.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/30 18:12
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:febs.properties"})
@ConfigurationProperties(prefix = "febs")
public class Properties {

    private ShiroProperties shiro = new ShiroProperties();
    private boolean openAopLog = true;
}

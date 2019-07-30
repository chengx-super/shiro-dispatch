package com.hengxc.shiro;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableAsync
@EnableTransactionManagement
@MapperScan("com.hengxc.shiro.*.mapper")

public class ShiroApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ShiroApplication.class)
                .run(args);
    }

}

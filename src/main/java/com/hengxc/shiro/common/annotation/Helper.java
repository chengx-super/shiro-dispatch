package com.hengxc.shiro.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/30 18:15
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Helper {
    @AliasFor(annotation = Component.class)
    String value() default "";
}

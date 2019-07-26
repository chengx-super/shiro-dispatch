package com.hengxc.shiro.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author chenguangxu
 * @date 2019/7/26 17:42
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface EndPoint {
    @AliasFor(annotation = Component.class)
    String value() default "";
}

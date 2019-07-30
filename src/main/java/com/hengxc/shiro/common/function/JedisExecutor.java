package com.hengxc.shiro.common.function;

import com.hengxc.shiro.common.exception.RedisConnectException;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/30 18:12
 */
@FunctionalInterface
public interface JedisExecutor<T, R> {
    R excute(T t) throws RedisConnectException;
}

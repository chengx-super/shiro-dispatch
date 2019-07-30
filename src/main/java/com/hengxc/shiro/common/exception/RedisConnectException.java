package com.hengxc.shiro.common.exception;

/**
 * Redis 连接异常
 *
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/30 18:12
 */
public class RedisConnectException extends FebsException {

    private static final long serialVersionUID = 1639374111871115063L;

    public RedisConnectException(String message) {
        super(message);
    }
}

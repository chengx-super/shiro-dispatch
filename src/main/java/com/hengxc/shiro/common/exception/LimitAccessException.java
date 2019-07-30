package com.hengxc.shiro.common.exception;

/**
 * 限流异常
 *
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/30 18:12
 */
public class LimitAccessException extends Exception {

    private static final long serialVersionUID = -3608667856397125671L;

    public LimitAccessException(String message) {
        super(message);
    }
}
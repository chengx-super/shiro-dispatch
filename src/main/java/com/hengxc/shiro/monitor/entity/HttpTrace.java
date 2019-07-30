package com.hengxc.shiro.monitor.entity;

import lombok.Data;

import java.io.Serializable;
import java.net.URI;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/26 10:17
 */

@Data
public class HttpTrace implements Serializable {

    private static final long serialVersionUID = 8286382834121710757L;

    /**
     * 请求时间
     */
    private String requestTime;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求 url
     */
    private URI url;
    /**
     * 响应状态
     */
    private int status;
    /**
     * 耗时
     */
    private Long timeTaken;

}

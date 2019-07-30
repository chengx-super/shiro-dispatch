package com.hengxc.shiro.monitor.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-26
 */
@Data
@TableName("t_base_log")
public class BaseLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId("ID")
    private Long id;

    /**
     * 操作用户
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 操作内容
     */
    @TableField("OPERATION")
    private String operation;

    /**
     * 耗时
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("TIME")
    private Long time;

    /**
     * 操作方法
     */
    @TableField("METHOD")
    private String method;

    /**
     * 方法参数
     */
    @TableField("PARAMS")
    private String params;

    /**
     * 操作者IP
     */
    @TableField("IP")
    private String ip;

    /**
     * 创建时间
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("CREATE_TIME")
    private Long createTime;

    /**
     * 操作地点
     */
    private String location;

    private transient String createTimeFrom;
    private transient String createTimeTo;

}

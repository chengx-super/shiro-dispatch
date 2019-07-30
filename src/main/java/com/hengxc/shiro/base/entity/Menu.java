package com.hengxc.shiro.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-25
 */
@Data
@TableName("t_base_menu")
public class Menu implements Serializable {

    // 菜单
    public static final String TYPE_MENU = "0";
    // 按钮
    public static final String TYPE_BUTTON = "1";
    public static final Long TOP_NODE = 0L;
    private static final long serialVersionUID = 1L;
    /**
     * 菜单/按钮ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId("MENU_ID")
    private Long menuId;

    /**
     * 上级菜单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    @TableField("MENU_NAME")
    private String menuName;

    /**
     * 菜单URL
     */
    @TableField("URL")
    private String url;

    /**
     * 权限标识
     */
    @TableField("PERMS")
    private String perms;

    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    @TableField("TYPE")
    private String type;

    /**
     * 排序
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("ORDER_NUM")
    private Long orderNum;

    /**
     * 创建时间
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("CREATE_TIME")
    private Long createTime;

    /**
     * 修改时间
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("MODIFY_TIME")
    private Long modifyTime;


}

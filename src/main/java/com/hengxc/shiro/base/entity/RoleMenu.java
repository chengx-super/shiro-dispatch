package com.hengxc.shiro.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 角色菜单关联表
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-25
 */
@Data
@TableName("t_base_role_menu")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("ROLE_ID")
    private Long roleId;

    /**
     * 菜单/按钮ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("MENU_ID")
    private Long menuId;


}

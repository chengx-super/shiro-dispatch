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
 * 角色表
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Data
@TableName("t_base_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId("ROLE_ID")
    private Long roleId;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 角色描述
     */
    @TableField("REMARK")
    private String remark;

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

    /**
     * 角色对应的菜单（按钮） id
     */
    private transient String menuIds;


}

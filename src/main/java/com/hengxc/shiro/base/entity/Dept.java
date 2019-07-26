package com.hengxc.shiro.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-25
 */
@Data
@TableName("t_base_dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @TableId("DEPT_ID")
    private Long deptId;

    /**
     * 上级部门ID
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 部门名称
     */
    @TableField("DEPT_NAME")
    private String deptName;

    /**
     * 排序
     */
    @TableField("ORDER_NUM")
    private Long orderNum;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Long createTime;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private Long modifyTime;


}

package com.hengxc.shiro.monitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hengxc.shiro.base.entity.User;
import com.hengxc.shiro.monitor.entity.LoginLog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 登录日志表 Mapper 接口
 * </p>
 *
 * @author chenguangxu
 * @since 2019-07-26
 */
public interface LoginLogMapper extends BaseMapper<LoginLog> {


    /**
     * 获取系统总访问次数
     *
     * @param
     * @return Long
     * @author chenguangxu
     * @date 2019/7/26 9:56
     */
    Long findTotalVisitCount();

    /**
     * 获取今日系统访问次数
     *
     * @param
     * @return Long
     * @author chenguangxu
     * @date 2019/7/26 9:55
     */
    Long findTodayVisitCount();

    /**
     * 获取今日系统访问ip数
     *
     * @param
     * @return Long
     * @author chenguangxu
     * @date 2019/7/26 9:55
     */
    Long findTodayIp();

    /**
     * 获取系统近七天访问记录
     *
     * @param user
     * @return 系统近七天访问记录
     * @author chenguangxu
     * @date 2019/7/26 9:54
     */
    List<Map<String, Object>> findLastSevenDaysVisitCount(User user);


}

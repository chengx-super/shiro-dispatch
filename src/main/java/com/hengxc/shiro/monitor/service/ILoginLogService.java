package com.hengxc.shiro.monitor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hengxc.shiro.base.entity.User;
import com.hengxc.shiro.common.entity.QueryRequest;
import com.hengxc.shiro.monitor.entity.LoginLog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 登录日志表 服务类
 * </p>
 *
 * @author ctrl+shift+r 一键替换
 * @since 2019-07-26
 */
public interface ILoginLogService extends IService<LoginLog> {

    /**
     * 获取登录日志信息 分页
     *
     * @param loginLog
     * @param request
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:02
     */
    IPage<LoginLog> findLoginLogs(LoginLog loginLog, QueryRequest request);

    /**
     * 保存登录日志
     *
     * @param loginLog
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:02
     */
    void saveLoginLog(LoginLog loginLog);

    /**
     * 删除登录日志
     *
     * @param ids
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:01
     */
    void deleteLoginLogs(String[] ids);

    /**
     * 获取系统总访问次数
     *
     * @param
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:01
     */
    Long findTotalVisitCount();

    /**
     * 获取系统今天访问次数
     *
     * @param
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:01
     */
    Long findTodayVisitCount();

    /**
     * 获取系统今天访问的ip 数量
     *
     * @param
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:00
     */
    Long findTodayIp();

    /**
     * 获取系统近七天的访问记录
     *
     * @param user
     * @return 系统七天的访问记录
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:00
     */
    List<Map<String, Object>> findLastSevenDaysVisitCount(User user);

}

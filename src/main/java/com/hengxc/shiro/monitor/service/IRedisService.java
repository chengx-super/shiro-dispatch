package com.hengxc.shiro.monitor.service;

import com.hengxc.shiro.common.exception.RedisConnectException;
import com.hengxc.shiro.monitor.entity.RedisInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/26 10:03
 */
public interface IRedisService {

    /**
     * 获取 redis 的详细信息
     *
     * @param
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    List<RedisInfo> getRedisInfo() throws RedisConnectException;

    /**
     * 获取 redis key 数量
     *
     * @param
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Map<String, Object> getKeysSize() throws RedisConnectException;

    /**
     * 获取 redis 内存信息
     *
     * @param
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Map<String, Object> getMemoryInfo() throws RedisConnectException;

    /**
     * 获取 key
     *
     * @param pattern 正则
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Set<String> getKeys(String pattern) throws RedisConnectException;

    /**
     * get命令
     *
     * @param key
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    String get(String key) throws RedisConnectException;

    /**
     * set命令
     *
     * @param key
     * @param value
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    String set(String key, String value) throws RedisConnectException;

    /**
     * set 命令
     *
     * @param key
     * @param value
     * @param milliscends 毫秒
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    String set(String key, String value, Long milliscends) throws RedisConnectException;

    /**
     * del命令
     *
     * @param key key
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Long del(String... key) throws RedisConnectException;

    /**
     * exists命令
     *
     * @param key key
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Boolean exists(String key) throws RedisConnectException;

    /**
     * pttl命令
     *
     * @param key key
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Long pttl(String key) throws RedisConnectException;

    /**
     * pexpire命令
     *
     * @param key
     * @param milliscends 毫秒
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Long pexpire(String key, Long milliscends) throws RedisConnectException;


    /**
     * zadd 命令
     *
     * @param key    key
     * @param score  score
     * @param member value
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Long zadd(String key, Double score, String member) throws RedisConnectException;

    /**
     * zrangeByScore 命令
     *
     * @param key
     * @param max
     * @param min
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Set<String> zrangeByScore(String key, String min, String max) throws RedisConnectException;

    /**
     * zremrangeByScore 命令
     *
     * @param key
     * @param start
     * @param end
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:04
     */
    Long zremrangeByScore(String key, String start, String end) throws RedisConnectException;

    /**
     * zrem 命令
     *
     * @param key
     * @param members
     * @return
     * @author ctrl+shift+r 一键替换
     * @date 2019/7/26 10:03
     */
    Long zrem(String key, String... members) throws RedisConnectException;
}

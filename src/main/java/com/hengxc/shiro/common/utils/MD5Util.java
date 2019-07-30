package com.hengxc.shiro.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/30 18:12
 */
public class MD5Util {

    private static final String ALGORITH_NAME = "md5";
    private static final int HASH_ITERATIONS = 5;

    protected MD5Util() {

    }

    public static String encrypt(String username, String password) {
        String source = StringUtils.lowerCase(username);
        password = StringUtils.lowerCase(password);
        return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(source), HASH_ITERATIONS).toHex();
    }
}

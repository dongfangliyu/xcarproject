package com.fintecher.sims.util;

import com.xiaoleilu.hutool.crypto.SecureUtil;

/**
 * @Author: jwdstef
 * @Description:
 * @Date 2017/5/31
 */
public class PasswordUtil {

    //盐
    public final static String SALT = "ZWJKD415";

    /**
     * 密码加密
     * 算法 -> md5(password + salt)
     *
     * @param password 密码
     * @return 加密后的密码
     */
    public static String encrypt(String password) {
        return SecureUtil.md5(password + SALT);
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(encrypt(str));
        System.out.println(SecureUtil.md5().digestHex(str));
    }

}

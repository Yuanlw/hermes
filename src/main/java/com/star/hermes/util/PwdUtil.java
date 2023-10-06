package com.star.hermes.util;

import org.springframework.util.DigestUtils;

import java.util.Random;

/**
 * TODO
 *
 * @Author yuanlw
 **/
public class PwdUtil {

    /**
     * 随机生成密码
     *
     * @param length
     * @return
     */
    public static String generateRandomPassword(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }

    /**
     * MD5加密  128位
     *
     * @param source
     * @return
     */
    public static String encrypt(String source) {
        return DigestUtils.md5DigestAsHex(source.getBytes());
    }
}

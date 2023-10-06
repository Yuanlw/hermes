package com.star.hermes.util;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Author yuanlw
 **/
@Service
public class MailService {

    /**
     * 邮箱格式校验
     *
     * @param mail
     * @return
     */
    public static boolean checkMail(String mail) {
        return mail.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    }

    /**
     * 获取邮箱名称
     *
     * @param email
     * @return
     */
    public static String getEmailPrefix(String email) {
        int index = email.indexOf("@");
        if (index > 0) {
            return email.substring(0, index);
        } else {
            return null;
        }
    }

    /**
     * 发送邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendMail(String to, String subject, String content) {
        // 调用邮件API完成发送逻辑
        //邮箱：starai@pretiosaturris.com
        //邮箱授权码：dYGUtjzAt7VuPeSd

    }
}

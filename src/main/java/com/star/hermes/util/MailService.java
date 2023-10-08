package com.star.hermes.util;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

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
     * @param toMail
     * @param subject
     * @param content
     */
    public void sendMail(String toMail, String subject, String content) throws MessagingException {
        // 调用邮件API完成发送逻辑
        //邮箱：starai@pretiosaturris.com
        //邮箱授权码：dYGUtjzAt7VuPeSd
        MimeMessage message = getMessage();

        InternetAddress to = new InternetAddress(toMail);
        message.setRecipient(Message.RecipientType.TO, to);

        message.setSentDate(new Date());

        message.setSubject(subject);

        message.setText(content);

        Transport.send(message);
    }

    /**
     * 固定模版
     *
     * @param toMail
     * @throws MessagingException
     */
    public void sendPWD(String toMail, String pwd) throws MessagingException {
        MimeMessage message = getMessage();

        InternetAddress to = new InternetAddress(toMail);
        message.setRecipient(Message.RecipientType.TO, to);

        message.setSentDate(new Date());

        message.setSubject("欢迎加入StarAI!");

        message.setText("       亲爱的用户,\n" + "\n" + "       欢迎注册StarAI账号。您的账号密码是:  " + pwd + " \n" + "\n" + "       " +
                                  "请妥善保管此密码并不要与他人共享。\n" + "\n" + "       欢迎加入StarAI大家庭!\n" + "       最佳问候," + "\n" +
                                  "       StarAI团队");

        Transport.send(message);

    }

    /**
     * 代码抽取
     *
     * @return
     * @throws MessagingException
     */
    private MimeMessage getMessage() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtphz.qiye.163.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(props, new MyAuthenticator("starai@pretiosaturris.com",
                                                                         "dYGUtjzAt7VuPeSd"));

        MimeMessage message = new MimeMessage(session);

        InternetAddress from = new InternetAddress("starai@pretiosaturris.com");
        message.setFrom(from);
        return message;
    }
}

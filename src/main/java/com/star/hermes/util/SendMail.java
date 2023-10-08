package com.star.hermes.util;

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
public class SendMail {

    //邮箱：starai@pretiosaturris.com
    //邮箱授权码：dYGUtjzAt7VuPeSd
    public void send() throws MessagingException {
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

        InternetAddress to = new InternetAddress("yuanliwei@daojia-inc.com");
        message.setRecipient(Message.RecipientType.TO, to);

        message.setSentDate(new Date());

        message.setSubject("欢迎加入StarAI!");

        message.setText("       亲爱的用户,\n" + "\n" + "       欢迎注册StarAI账号。您的账号密码是: \"\"\" + password + \"\"\"\n" + "\n" + "       请妥善保管此密码并不要与他人共享。\n" + "\n" + "       欢迎加入StarAI大家庭!\n" + "       最佳问候,\n" + "       StarAI团队");

        Transport.send(message);

    }

    public static void main(String[] args) {

        try {
            new SendMail().send();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("邮件已发送");
    }
}

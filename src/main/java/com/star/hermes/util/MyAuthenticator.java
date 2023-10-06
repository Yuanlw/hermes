package com.star.hermes.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * TODO
 *
 * @Author yuanlw
 **/
public class MyAuthenticator extends Authenticator {

    private String userName;
    private String passWord;

    public MyAuthenticator(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, passWord);
    }
}

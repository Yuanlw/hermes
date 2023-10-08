package com.star.hermes.controllers;

import com.star.hermes.jwt.JwtUtil;
import com.star.hermes.service.BusinessService;
import com.star.hermes.service.UserService;
import com.star.hermes.util.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * 商业入口
 *
 * @Author yuanlw
 **/
@Controller
@RequestMapping("/starAI")
public class BusinessController extends BaseController {
    Logger logger = LoggerFactory.getLogger(BusinessController.class);

    @Resource
    private UserService userService;
    @Resource
    private MailService mailService;
    @Resource
    private BusinessService businessService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 人工充值
     *
     * @param mail
     * @param type
     * @return
     */
    @RequestMapping(value = "/pp/recharge", method = RequestMethod.GET)
    public void Recharge(String mail, int type) {

        //现查是否存在

        //人工充值
    }

}

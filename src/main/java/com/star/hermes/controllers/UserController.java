package com.star.hermes.controllers;

import com.star.hermes.common.RespCode;
import com.star.hermes.common.TcRespDto;
import com.star.hermes.dto.UserDto;
import com.star.hermes.entity.User;
import com.star.hermes.enu.BusinessTypeEnum;
import com.star.hermes.jwt.JwtUtil;
import com.star.hermes.service.UserService;
import com.star.hermes.util.MailService;
import com.star.hermes.util.PwdUtil;
import org.hibernate.internal.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.Date;

/**
 * UserController <br>
 * <p>
 * 这个类，主要是注册、登录和找回密码。
 *
 * @since 2023-8-31 18:05:27
 */
@Controller
@RequestMapping("/starAI")
public class UserController extends BaseController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final int COUNT = 100;

    @Resource
    private UserService userService;
    @Resource
    private MailService mailService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 注册使用邮箱注册，这边校验邮箱，生成密码，发送给邮件，并加密密码保存起来。
     */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public TcRespDto register(String mail) throws MessagingException {
        logger.info("register mail={}", mail);

        // 校验邮箱格式
        if (!MailService.checkMail(mail)) {
            return TcRespDto.fail("邮箱格式不正确");
        }
        //邮箱是否已注册
        User checkMail = userService.findByEmail(mail);
        if (checkMail == null || checkMail.getId() <= 0) {
            return TcRespDto.fail("邮箱已注册");
        }

        // 生成随机密码
        String password = PwdUtil.generateRandomPassword(8);
        // 通过邮件服务发送验证码
        try {
            mailService.sendPWD(mail, password);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        //加密
        String encryptPwd = PwdUtil.encrypt(password);

        // 保存到数据库
        UserDto userDto = new UserDto(BusinessTypeEnum.FREE.getCode(), COUNT, new Date(), mail,
                                      MailService.getEmailPrefix(mail), encryptPwd);
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        userService.save(user);

        return TcRespDto.success("验证码已发送到邮件中，请查收。");
    }

    //login

    /**
     * 用邮箱和密码，登录，登录状态365天
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public TcRespDto login(String mail, String password) {
        logger.info("login mail={}", mail);
        if (StringHelper.isBlank(mail) || StringHelper.isBlank(password)) {
            TcRespDto.fail(RespCode.INVALID_PARAM.getCode(), RespCode.INVALID_PARAM.getMsg());
        }

        String encryptPwd = PwdUtil.encrypt(password);

        User user = userService.findByEmailAndPassword(mail, encryptPwd);
        if (user == null) {
            return TcRespDto.fail(RespCode.UNAUTHORIZED.getCode(), RespCode.UNAUTHORIZED.getMsg());
        }

        String token = jwtUtil.generateToken(user);

        return TcRespDto.success(token);
    }

    //call back pwd

    /**
     * 先check邮箱是否存在，如果存在，生成一个密码，保存后，发送给找回密码的邮箱。5s后自动跳转到登录页。
     */

    @RequestMapping(value = "/recover", method = RequestMethod.POST)
    public TcRespDto recover(String mail) {
        logger.info("recover mail={}", mail);
        // 校验邮箱格式
        if (!MailService.checkMail(mail)) {
            return TcRespDto.fail("邮箱格式不正确");
        }
        User byEmail = userService.findByEmail(mail);
        if (ObjectUtils.isEmpty(byEmail)) {
            return TcRespDto.fail("邮箱不存在");
        }

        // 生成随机密码
        String password = PwdUtil.generateRandomPassword(8);
        // 通过邮件服务发送验证码
        try {
            mailService.sendPWD(mail, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 保存到数据库
        String encryptPwd = PwdUtil.encrypt(password);
        UserDto userDto = new UserDto(byEmail.getBusinessType(), byEmail.getCount(), byEmail.getCreateTime(), mail,
                                      byEmail.getName(), encryptPwd);
        userDto.setId(byEmail.getId());//主键
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        userService.update(user);

        return TcRespDto.success("登录码已发送到邮件中，请查收！");

    }

}

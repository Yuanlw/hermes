package com.star.hermes.controllers;

import com.star.hermes.service.UserPromptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Description: UserPromptController <br>
 * <p>
 * Do not edit this file It was auto-generated by Code-Generator
 *
 * @since 2023-10-8 16:54:27
 */
@Controller
@RequestMapping("/")
public class UserPromptController extends BaseController {

    @Resource
    private UserPromptService userPromptService;

}

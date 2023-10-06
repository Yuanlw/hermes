package com.star.hermes.jwt;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

/**
 * @ClassName Authenticated
 * @Description TODO
 * @Author yuanlw
 * @Date 2023/9/13 16:13
 * @Version 1.0
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface Authenticated {
}

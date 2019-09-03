package com.yckj.annotation;

import java.lang.annotation.*;

/**
 * 登录效验
 *
 * @author Finder zhangzhili92@163.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}

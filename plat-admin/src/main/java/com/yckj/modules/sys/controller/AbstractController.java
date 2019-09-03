package com.yckj.modules.sys.controller;

import com.yckj.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Controller公共组件
 *
 * @author Finder zhangzhili92@163.com
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected Long getDeptId() {
		return getUser().getDeptId();
	}
}

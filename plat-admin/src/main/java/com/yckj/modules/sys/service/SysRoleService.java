package com.yckj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yckj.common.utils.PageUtils;
import com.yckj.modules.sys.entity.SysRoleEntity;

import java.util.Map;


/**
 * 角色
 *
 * @author Finder zhangzhili92@163.com
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveRole(SysRoleEntity role);

	void update(SysRoleEntity role);
	
	void deleteBatch(Long[] roleIds);

}

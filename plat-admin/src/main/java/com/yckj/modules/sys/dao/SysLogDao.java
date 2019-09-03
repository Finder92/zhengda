package com.yckj.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yckj.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 *
 * @author Finder zhangzhili92@163.com
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}

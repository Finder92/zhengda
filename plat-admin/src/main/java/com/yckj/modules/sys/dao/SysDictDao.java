package com.yckj.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yckj.modules.sys.entity.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典
 *
 * @author Finder zhangzhili92@163.com
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {
	
}

package com.yckj.modules.oss.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yckj.modules.oss.entity.SysOssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 * @author Finder zhangzhili92@163.com
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
	
}

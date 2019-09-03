package com.yckj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yckj.entity.TokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Token
 *
 * @author Finder zhangzhili92@163.com
 */
@Mapper
public interface TokenDao extends BaseMapper<TokenEntity> {
	
}



package com.yckj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yckj.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Finder zhangzhili92@163.com
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}

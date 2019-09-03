package com.yckj.modules.megvii.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yckj.modules.megvii.entity.MegAttendDetailEntity;
import com.yckj.modules.megvii.entity.MegAttendDetailEntity;
import com.yckj.modules.megvii.entity.MegAttendDetailEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author Finder
 * @email zhangzhili92@163.com
 * @date 2019-08-02 15:40:07
 */
@Mapper
public interface MegAttendDetailDao extends BaseMapper<MegAttendDetailEntity> {
    List<MegAttendDetailEntity> selectAll();
	
}

package com.yckj.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yckj.modules.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 * @author Finder zhangzhili92@163.com
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
	
}

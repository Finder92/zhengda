package com.yckj.modules.megvii.dao;


import com.yckj.modules.megvii.entity.MegAttendEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface MegAttendDao extends BaseMapper<MegAttendEntity> {

    List<MegAttendEntity> queryByJobNumberAndDate(MegAttendEntity megAttendEntity);

    void updateByJobNum(MegAttendEntity megAttendEntity);

    List<MegAttendEntity> queryByJobNumberAndTime(MegAttendEntity megAttendEntity);


    List<MegAttendEntity> selectAll();
}

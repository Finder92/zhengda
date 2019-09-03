package com.yckj.modules.megvii.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.yckj.common.utils.PageUtils;
import com.yckj.modules.megvii.entity.MegAttendEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Finder
 * @email zhangzhili92@163.com
 * @date 2019-08-02 15:40:07
 */
public interface MegAttendService extends IService<MegAttendEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<MegAttendEntity> queryByJobNumberAndDate(MegAttendEntity megAttendEntity);

    List<MegAttendEntity> queryByJobNumberAndTime(MegAttendEntity megAttendEntity);

    void updateByJobNum(MegAttendEntity megAttendEntity);

    List<MegAttendEntity> queryByPageHelp(Map<String,Integer> paramsMap);
}


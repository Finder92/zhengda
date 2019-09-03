package com.yckj.modules.megvii.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yckj.common.utils.PageUtils;
import com.yckj.common.utils.Query;
import com.yckj.modules.megvii.dao.MegAttendDetailDao;
import com.yckj.modules.megvii.entity.MegAttendDetailEntity;
import com.yckj.modules.megvii.service.MegAttendDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("megAttendDetailService")
public class MegAttendDetailServiceImpl extends ServiceImpl<MegAttendDetailDao, MegAttendDetailEntity> implements MegAttendDetailService {

    @Autowired
    private MegAttendDetailDao megAttendDetailDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MegAttendDetailEntity> page = this.page(
                new Query<MegAttendDetailEntity>().getPage(params),
                new QueryWrapper<MegAttendDetailEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<MegAttendDetailEntity> queryByPageHelp(Map<String, Integer> paramsMap) {
        PageHelper.startPage(paramsMap.get("pageNum"), paramsMap.get("pageSize"));
        List<MegAttendDetailEntity> megAttendDetailEntityList = megAttendDetailDao.selectAll();
        PageInfo<MegAttendDetailEntity> pageInfo = new PageInfo<>(megAttendDetailEntityList);
        List list = pageInfo.getList();
        return list;
    }

}

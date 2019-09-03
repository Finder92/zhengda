package com.yckj.modules.megvii.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yckj.modules.megvii.dao.MegAttendDao;
import com.yckj.modules.megvii.entity.MegAttendEntity;
import com.yckj.modules.megvii.service.MegAttendService;
import com.yckj.modules.megvii.dao.MegAttendDao;
import com.yckj.modules.megvii.entity.MegAttendEntity;
import com.yckj.modules.megvii.service.MegAttendService;
import com.yckj.common.utils.PageUtils;
import com.yckj.common.utils.Query;
import com.yckj.modules.megvii.dao.MegAttendDao;
import com.yckj.modules.megvii.entity.MegAttendEntity;
import com.yckj.modules.megvii.service.MegAttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("megAttendService")
public class MegAttendServiceImpl extends ServiceImpl<MegAttendDao, MegAttendEntity> implements MegAttendService {
    @Autowired
    private MegAttendDao megAttendDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MegAttendEntity> page = this.page(
                new Query<MegAttendEntity>().getPage(params),
                new QueryWrapper<MegAttendEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<MegAttendEntity> queryByJobNumberAndDate(MegAttendEntity megAttendEntity) {
        return megAttendDao.queryByJobNumberAndDate(megAttendEntity);
    }

    @Override
    public List<MegAttendEntity> queryByJobNumberAndTime(MegAttendEntity megAttendEntity) {
        return megAttendDao.queryByJobNumberAndTime(megAttendEntity);
    }

    @Override
    public void updateByJobNum(MegAttendEntity megAttendEntity) {
        this.megAttendDao.updateByJobNum(megAttendEntity);
    }

    @Override
    public List<MegAttendEntity> queryByPageHelp(Map<String,Integer> paramsMap) {
        PageHelper.startPage(paramsMap.get("pageNum"),paramsMap.get("pageSize"));
        List<MegAttendEntity> megAttendEntityList = megAttendDao.selectAll();
        PageInfo<MegAttendEntity> pageInfo = new PageInfo<MegAttendEntity>(megAttendEntityList);
        List list = pageInfo.getList();
        return list;
    }
}

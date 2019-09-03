package com.yckj.modules.attend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yckj.common.utils.Constant;
import com.yckj.modules.attend.entity.AttendUserEntity;
import com.yckj.modules.attend.dao.AttendUserDao;
import com.yckj.modules.attend.entity.AttendUserEntity;
import com.yckj.modules.attend.service.AttendUserService;
import com.yckj.common.utils.PageUtils;
import com.yckj.common.utils.Query;
import com.yckj.modules.attend.dao.AttendUserDao;
import com.yckj.modules.attend.entity.AttendUserEntity;
import com.yckj.modules.attend.service.AttendUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("attendUserService")
public class AttendUserServiceImpl extends ServiceImpl<AttendUserDao, AttendUserEntity> implements AttendUserService {
    @Autowired
    private AttendUserDao attendUserDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String attendUssname = (String)params.get("attendUssname");
        IPage<AttendUserEntity> page = this.page(
                new Query<AttendUserEntity>().getPage(params),
                new QueryWrapper<AttendUserEntity>()
                    .like(StringUtils.isNotBlank(attendUssname),"attend_ussname",attendUssname)
                    .apply(params.get(Constant.SQL_FILTER)!=null,(String)params.get(Constant.SQL_FILTER))
        );

        return new PageUtils(page);
    }

    @Override
    public boolean updateSignState(Long attendUserid) {
        return attendUserDao.updateSignState(attendUserid);
    }

    @Override
    public boolean batchUpdateSignState(List<Long> userId) {
        return attendUserDao.batchUpdateSignState(userId);
    }

    @Override
    public List<AttendUserEntity> queryByAttendUserName(String attendUserName) {
        return attendUserDao.queryByAttendUserName(attendUserName);
    }
}

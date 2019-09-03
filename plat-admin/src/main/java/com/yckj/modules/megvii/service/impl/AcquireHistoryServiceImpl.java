package com.yckj.modules.megvii.service.impl;

import com.yckj.common.utils.DateUtils;
import com.yckj.common.utils.JSONUtils;
import com.yckj.modules.megvii.dto.history.DataDto;
import com.yckj.modules.megvii.dto.history.HistoryDataDTO;
import com.yckj.modules.megvii.dto.history.SubjectDto;
import com.yckj.modules.megvii.entity.MegAttendDetailEntity;
import com.yckj.modules.megvii.entity.MegAttendEntity;
import com.yckj.modules.megvii.service.AcquireHistoryService;
import com.yckj.modules.megvii.service.MegAttendDetailService;
import com.yckj.modules.megvii.service.MegAttendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName AcquireHistoryServiceImpl
 * @Description TODO
 * @Author Finder
 * @Date 2019/8/5 11:42
 **/
@Transactional(rollbackFor = Exception.class)
@Service
@Slf4j
public class AcquireHistoryServiceImpl implements AcquireHistoryService {

    @Autowired
    private MegAttendService megAttendService;

    @Autowired
    private MegAttendDetailService megAttendDetailService;

    @Override
    public void dealWithHistoryProcess(String result) {
        try {
            HistoryDataDTO historyDataDTO = JSONUtils.json2pojo(result, HistoryDataDTO.class);
            List<DataDto> dataDtoList = historyDataDTO.getData();
            log.info("获取" + "{}", dataDtoList.size() + "条识别结果");
            for (DataDto dataDto : dataDtoList) {
                log.info("screenId:{}", dataDto.getScreen().getId());
                log.info("timestamp:{}", DateUtils.transDate(DateUtils.DATE_TIME_PATTERN, Long.valueOf(dataDto.getTimestamp()) * 1000));
                SubjectDto subjectDto = dataDto.getSubject();
                if (subjectDto == null) {
                    continue;
                }
                MegAttendEntity megAttendEntity = new MegAttendEntity();
                //公司Id
                megAttendEntity.setCompanyId(Long.valueOf(subjectDto.getCompany_id()));
                //公司名
                megAttendEntity.setCompanyName("companyName");
                //员工Id(取工号)
                megAttendEntity.setEmpId(Long.parseLong(subjectDto.getJob_number()));
                //员工名
                megAttendEntity.setEmpName(subjectDto.getName());
                //日期
                //取识别的时间戳对年月日,乘以1000是因为获取到的时间戳为秒
                Long timestamp = Long.valueOf(dataDto.getTimestamp()) * 1000;
                megAttendEntity.setDate(DateUtils.transDate(DateUtils.DATE_PATTERN, timestamp));
                //识别时间 yyyy-MM-dd HH:mm:ss
                megAttendEntity.setRecognized(DateUtils.transDate(DateUtils.DATE_TIME_PATTERN, timestamp));

                MegAttendDetailEntity megAttendDetailEntity = new MegAttendDetailEntity();
                //公司Id
                megAttendDetailEntity.setCompanyId(Long.valueOf(subjectDto.getCompany_id()));
                //公司名
                megAttendDetailEntity.setCompanyName("companyName");
                //部门Id----没有值
                megAttendDetailEntity.setDeptId(0L);
                //部门名称
                megAttendDetailEntity.setDeptName(subjectDto.getDepartment());
                //员工Id
                megAttendDetailEntity.setEmpId(Long.parseLong(subjectDto.getJob_number()));
                //员工姓名
                megAttendDetailEntity.setEmpName(subjectDto.getName());
                //日期
                megAttendDetailEntity.setDate(DateUtils.transDate(DateUtils.DATE_PATTERN, timestamp));
                //视频识别时间
                megAttendDetailEntity.setVideoTime(DateUtils.transDate(DateUtils.DATE_TIME_PATTERN, timestamp));
                //监控地点
                megAttendDetailEntity.setPlace(dataDto.getScreen().getCamera_position());
                //照片
                megAttendDetailEntity.setPhoto(subjectDto.getPhotos().get(0).getUrl());
                //视频
                megAttendDetailEntity.setVideo("");
                //10分钟去获取一次历史记录
                //如果该员工同一时间点的记录被多次采集到,只保存一次记录
                List<MegAttendEntity> megAttendEntityList = megAttendService.queryByJobNumberAndTime(megAttendEntity);
                if (megAttendEntityList.size() == 0 || megAttendEntityList == null) {
                    //保存签到信息
                    megAttendService.save(megAttendEntity);
                    //保存签到明细
                    this.megAttendDetailService.save(megAttendDetailEntity);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.yckj.modules.megvii.api;

import com.yckj.modules.megvii.entity.MegAttendDetailEntity;
import com.yckj.modules.megvii.entity.MegAttendEntity;
import com.yckj.modules.megvii.service.MegAttendDetailService;
import com.yckj.modules.megvii.service.MegAttendService;
import com.yckj.modules.megvii.entity.MegAttendDetailEntity;
import com.yckj.modules.megvii.entity.MegAttendEntity;
import com.yckj.modules.megvii.service.MegAttendDetailService;
import com.yckj.modules.megvii.service.MegAttendService;
import com.yckj.modules.megvii.entity.MegAttendDetailEntity;
import com.yckj.modules.megvii.entity.MegAttendEntity;
import com.yckj.modules.megvii.service.MegAttendDetailService;
import com.yckj.modules.megvii.service.MegAttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HistoryRecognizedController
 * @Description TODO 提供给海科金的历史识别记录
 * @Author Finder
 * @Date 2019/8/5 10:37
 **/
@RestController
@RequestMapping("/megvii")
public class HistoryRecognizedController {

    @Autowired
    private MegAttendService megAttendService;

    @Autowired
    private MegAttendDetailService megAttendDetailService;
    @RequestMapping("/attendHistory")
    public List<MegAttendEntity> attendHistory(Integer pageNum, Integer pageSize){
        pageNum = pageNum==null?1:pageNum;
        pageSize = pageSize==null?10:pageSize;
        Map<String,Integer> paramsMap = new HashMap<>();
        paramsMap.put("pageNum",pageNum);
        paramsMap.put("pageSize",pageSize);
        List<MegAttendEntity> list = megAttendService.queryByPageHelp(paramsMap);
        return list;
    }

    @RequestMapping("/detailHistory")
    public List<MegAttendDetailEntity> attendDetailHistory(Integer pageNum, Integer pageSize){
        pageNum = pageNum==null?1:pageNum;
        pageSize = pageSize==null?10:pageSize;
        Map<String,Integer> paramsMap = new HashMap<>();
        paramsMap.put("pageNum",pageNum);
        paramsMap.put("pageSize",pageSize);
        List<MegAttendDetailEntity> list = megAttendDetailService.queryByPageHelp(paramsMap);
        return list;
    }
}

package com.yckj.modules.megvii.task;

import com.alibaba.fastjson.JSONObject;
import com.yckj.modules.megvii.config.RequestConfig;
import com.yckj.modules.megvii.service.AcquireHistoryService;
import com.yckj.modules.megvii.service.HttpClientService;
import com.yckj.modules.job.task.ITask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName AcquireHistoryTask
 * @Description TODO 定时抓取历史列表
 * @Author Finder
 * @Date 2019/8/2 18:58
 **/
@Slf4j
@Component("acquireHistoryTask")
public class AcquireHistoryTask implements ITask {
    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private RequestConfig requestConfig;

    @Autowired
   private AcquireHistoryService acquireHistoryService;

    private int loginState = 1;

    @Override
    public void run(String params) {
        while (loginState != 0) {
            log.info("执行登录...");
            Map<String, String> paramsMap = new ConcurrentHashMap<>();
            paramsMap.put("username", requestConfig.getUsername());
            paramsMap.put("password", requestConfig.getPassword());
            String result = httpClientService.doPost(requestConfig.getLoginUrl(), paramsMap);
            JSONObject jsonObject =(JSONObject) JSONObject.parse(result);
            result = jsonObject.get("code").toString();
            log.info("result:{登录返回状态码:=}"+result);
            log.info("result:{}",result);
            loginState = Integer.valueOf(result);
        }
        try {
            Map<String,String> paramsMap = new ConcurrentHashMap<>();
            //定时每次取当前时间的十分钟前
            Calendar calendar = Calendar.getInstance();
            long end =calendar.getTimeInMillis()/1000;
            paramsMap.put("end",String.valueOf(end));
            calendar.add(Calendar.MINUTE,-10);
            //将取到的时间戳转为秒(取到的为毫秒)
            long start= calendar.getTimeInMillis()/1000;
            paramsMap.put("start",String.valueOf(start));
            paramsMap.put("user_role",String.valueOf(0));
            String result = httpClientService.doGet(requestConfig.getDetailUrl(),paramsMap);
            acquireHistoryService.dealWithHistoryProcess(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

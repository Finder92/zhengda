package com.yckj.modules.megvii.controller;

import com.alibaba.fastjson.JSONObject;
import com.yckj.common.utils.R;
import com.yckj.modules.megvii.config.RequestConfig;
import com.yckj.modules.megvii.service.AcquireHistoryService;
import com.yckj.modules.megvii.service.HttpClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName HttpController
 * @Description TODO
 * @Author Finder
 * @Date 2019/7/29 14:50
 **/
@RestController
@Slf4j
public class AcquireHistoryController {
    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private RequestConfig requestConfig;

    @Autowired
    private AcquireHistoryService acquireHistoryService;

    @RequestMapping("/get")
    public String getHttp(){
        String result = httpClientService.doGet("http://www.baidu.com");
        log.info("result:{}",result);
        return result;
    }
    /**
     * @Author Finder
     * @Description //TODO 为了获取cookie
     * @Date 16:09 2019/7/29
     * @Param 
     * @return
     */
    public String loginMegvii(){
        Map<String,String> params = new ConcurrentHashMap<>();
        params.put("username",requestConfig.getUsername());
        params.put("password",requestConfig.getPassword());
        String result = httpClientService.doPost(requestConfig.getLoginUrl(),params);
        JSONObject jsonObject =(JSONObject) JSONObject.parse(result);
        result = jsonObject.get("code").toString();
        log.info("result:{登录返回状态码:=}"+result);
        log.info("result:{}",result);
        return result;
    }
    /**
     * @Author Finder
     * @Description //TODO 获取历史数据,此接口不要求登陆本后台管理系统,应客户要求无界面话操作
     * @Date 16:54 2019/7/29
     * @Param 
     * @return 
     */
    @RequestMapping("/megvii/getHistoryList")
    public R getHistoryList()throws Exception{
        String code = this.loginMegvii();
        if(Integer.valueOf(code)==0){
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
            return  R.ok();
        }
        return R.error(Integer.valueOf(code),"请参考错误解析码");

    }


}

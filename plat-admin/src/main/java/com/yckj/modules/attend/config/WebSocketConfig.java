package com.yckj.modules.attend.config;

import com.alibaba.fastjson.JSONObject;
import com.yckj.common.utils.JSONUtils;
import com.yckj.modules.attend.dto.video.VideoDTO;
import com.yckj.modules.attend.entity.AttendUserEntity;
import com.yckj.modules.attend.service.AttendUserService;
import com.yckj.modules.megvii.service.HttpClientService;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WebSocketConfig
 * @Description TODO
 * @Author Finder
 * @Date 2019/7/30 16:22
 */

@Slf4j
@Component
public class WebSocketConfig {
    @Autowired
    private AttendConfig attendConfig;

    @Autowired
    private AttendUserService attendUserService;

    @Autowired
    private HttpClientService httpClientService;

    @Bean
    public WebSocketClient webSocketClient() {
        try {
            //主机地址
            String wsUrl = attendConfig.getWsUrl();
            //视频流地址
            String rtspUrl = attendConfig.getRtspUrl();
            //websocket连接
            String ws = wsUrl + "?url=" + URLEncoder.encode(rtspUrl, "utf-8");
            WebSocketClient webSocketClient = new WebSocketClient(new URI(ws), new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    log.info("[websocket] 连接成功");
                }
                @Override
                public void onMessage(String message) {
                    //log.info("原始消息"+message);
                    JSONObject jsonObject = (JSONObject) JSONObject.parse(message);
                    String typeValue = jsonObject.getString("type");
                    if (typeValue.equals("recognized")) {
                        log.info("[websocket] 收到消息={}", message);
                        VideoDTO videoDTO = null;
                        try {
                            videoDTO = JSONUtils.json2pojo(message, VideoDTO.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String attendUserName = videoDTO.getPerson().getName();
                        String avatar = videoDTO.getPerson().getAvatar();
                        log.info("avatar:{}",avatar);
                        Map<String,String> paramsMap = new HashMap<>();
                        paramsMap.put("name",attendUserName);
                        paramsMap.put("pictureUrl",avatar);
                        paramsMap.put("age",20+"");
                        paramsMap.put("description","");
                        httpClientService.doPost("http://192.168.1.29:8080/message",paramsMap);
                        try {
                            int subjectType = videoDTO.getPerson().getSubject_type();
                            AttendUserEntity attendUserEntity = new AttendUserEntity();
                            attendUserEntity.setAttendUsertype(String.valueOf(videoDTO.getPerson().getSubject_type()));
                            attendUserEntity.setAttendUssname(attendUserName);
                            attendUserEntity.setAttendSignstate("0");
                            attendUserEntity.setAttendCreatetime(new Date());
                            //根据用户名查询,如果已存在,略过保存
                            List<AttendUserEntity> attendUserEntityList = attendUserService.queryByAttendUserName(attendUserName);
                            if (attendUserEntityList.size() == 0 || null == attendUserEntityList) {
                                log.info("attendUserName:{},subjectType:{}", attendUserName + "在当前系统中不存在,即将创建新的记录,当前时间为:" + new Date(), subjectType);
                                attendUserService.save(attendUserEntity);
                            }

                            log.info("attendUserName:{},subjectType:{}", attendUserName + "已在系统中存在,当前时间为:" + new Date(), subjectType);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                @Override
                public void onClose(int code, String reason, boolean remote) {
                    log.info("[websocket] 退出连接");
                }

                @Override
                public void onError(Exception ex) {
                    log.info("[websocket] 连接错误={}", ex.getMessage());
                }
            };
            webSocketClient.connect();
            return webSocketClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}

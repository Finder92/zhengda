package com.yckj.modules.attend.controller;

import com.alibaba.fastjson.JSON;
import com.yckj.modules.attend.dto.message.ShowDto;
import com.yckj.modules.attend.websocket.server.WebSocketServer;
import com.yckj.modules.attend.dto.message.ShowDto;
import com.yckj.modules.attend.websocket.server.WebSocketServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @ClassName MessageController
 * @Description TODO
 * @Author Finder
 * @Date 2019/8/7 8:38
 **/
@RestController
public class MessageController {
    @Resource
    WebSocketServer webSocketServer;
    @RequestMapping("/message")
    public String reciveMessage(ShowDto showDto){
        String message = null;
        try {
            message = JSON.toJSONString(showDto);
            webSocketServer.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}

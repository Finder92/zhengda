package com.yckj.modules.megvii.dto.history;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName HistoryDataDTO
 * @Description TODO
 * @Author Finder
 * @Date 2019/7/29 13:09
 **/
@Data
public class HistoryDataDTO {
    /**
     * code : 0
     * data : [{"age":36.7407,"company_id":1,"confidence":81.1256,"event_type":0,"fmp":0,"fmp_error":false,"gender":0.93209,"group":-1,"id":3521,"photo":"/static/upload/event/2019-07-29/v2_9bfc11d870245bf2f2e827cbf5027a297cde0513.jpg","quality":0.99618,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject":{"avatar":"/static/upload/photo/2019-07-29/v2_f6662763b39b24545e2c27d525b043c40effb0a7.jpg","birthday":null,"come_from":"","company_id":1,"create_time":1564366708,"department":"","description":"","email":"","end_time":0,"entry_date":null,"gender":0,"id":36,"interviewee":"","interviewee_pinyin":"","job_number":"0","name":"张志立","password_reseted":false,"phone":"15318346841","photos":[{"company_id":1,"id":95,"quality":0.99644,"subject_id":36,"url":"/static/upload/photo/2019-07-29/v2_f6662763b39b24545e2c27d525b043c40effb0a7.jpg","version":7}],"pinyin":"zhangzhili","purpose":0,"remark":"hello  world","start_time":0,"subject_type":3,"title":"","visit_notify":false},"subject_id":36,"timestamp":1564371780,"uuid":"b1a23c86-ea0e-497c-9c13-c87ab702d0ef"},{"age":33.1303,"company_id":1,"confidence":46.4783,"event_type":0,"fmp":0,"fmp_error":false,"gender":0.971662,"group":-1,"id":3520,"photo":"/static/upload/event/2019-07-29/v2_dba85aa112fc11fbcac7119f2298fae27d0fb19a.jpg","quality":0.990535,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject_id":null,"timestamp":1564371346,"uuid":"f6b7ad1a-7200-4381-8a1a-dcca65fe4078"},{"age":62.8819,"company_id":1,"confidence":30.2232,"event_type":0,"fmp":0,"fmp_error":false,"gender":0.940745,"group":-1,"id":3519,"photo":"/static/upload/event/2019-07-29/v2_0fadafe6c4392663bfa1beebae8c58aa742ed9c3.jpg","quality":0.96685,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject_id":null,"timestamp":1564371255,"uuid":"70cbcf3f-c628-4014-a6a0-c15d5d1ff982"},{"age":52.3991,"company_id":1,"confidence":39.2122,"event_type":0,"fmp":0,"fmp_error":false,"gender":0.574208,"group":-1,"id":3518,"photo":"/static/upload/event/2019-07-29/v2_865a89d4813f5796692068d5089a25c4f9452f66.jpg","quality":0.847448,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject_id":null,"timestamp":1564371135,"uuid":"f7f07567-cf9d-4134-a246-819ee58a3c11"},{"age":41.8864,"company_id":1,"confidence":42.0668,"event_type":0,"fmp":0,"fmp_error":false,"gender":0.727231,"group":-1,"id":3517,"photo":"/static/upload/event/2019-07-29/v2_da17755a9f6a3822b316cf1bf96f8b244049d279.jpg","quality":0.806569,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject_id":null,"timestamp":1564371123,"uuid":"f585d4c3-4bad-4d7c-9262-9098c729a67c"},{"age":52.191,"company_id":1,"confidence":57.1417,"event_type":0,"fmp":0,"fmp_error":false,"gender":0.948343,"group":-1,"id":3516,"photo":"/static/upload/event/2019-07-29/v2_f71e30767e474f23e1daaaf96c00d2f0ce660543.jpg","quality":0.775082,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject_id":null,"timestamp":1564371110,"uuid":"35e17745-33f0-4021-b5df-dd04f39d50da"},{"age":49.6892,"company_id":1,"confidence":0,"event_type":1,"fmp":0,"fmp_error":false,"gender":0.974277,"group":-1,"id":3515,"photo":"/static/upload/event/2019-07-29/v2_fdbd977587e3044684b379c275756ac79454ba52.jpg","quality":-0.202635,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject_id":null,"timestamp":1564371098,"uuid":"03e73c18-7e7f-442d-ad84-607fd39a003c"},{"age":41.9486,"company_id":1,"confidence":0,"event_type":1,"fmp":0,"fmp_error":false,"gender":0.288902,"group":-1,"id":3514,"photo":"/static/upload/event/2019-07-29/v2_c185627922a98d44b88a9fb494bfca9b6fdbefab.jpg","quality":-0.0359108,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject_id":null,"timestamp":1564371097,"uuid":"5bf5a3c1-6cf3-47c4-a0c3-02ddae5d300f"},{"age":42.8246,"company_id":1,"confidence":0,"event_type":1,"fmp":0,"fmp_error":false,"gender":0.972405,"group":-1,"id":3513,"photo":"/static/upload/event/2019-07-29/v2_3534532d409e13e20a28b02b8866b930593215ac.jpg","quality":-0.056582,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject_id":null,"timestamp":1564371093,"uuid":"f9bbefc5-9ee7-430d-9a07-99b0a7d89f46"},{"age":36.0189,"company_id":1,"confidence":0,"event_type":1,"fmp":0,"fmp_error":false,"gender":0.840101,"group":-1,"id":3512,"photo":"/static/upload/event/2019-07-29/v2_f3ac95c1ca082f7a2618ed1191f8e4a8c7feab18.jpg","quality":-0.0618519,"screen":{"allow_all_subjects":true,"allow_visitor":true,"box_address":"192.168.1.50","box_heartbeat":1564371785,"box_status":"0","box_token":"6d72c133-71e4-478d-80b5-917355b90e1b","camera_address":"rtsp://192.168.1.11/user=admin&password=&channel=1&stream=0.sdp?","camera_name":"","camera_position":"耀聪科技","camera_status":"0","description":null,"id":9,"is_select":1,"network_switcher":"","network_switcher_drive":0,"network_switcher_status":null,"network_switcher_token":null,"screen_token":"b4b99166-f096-4e8f-a82d-233ebbe7ee46","type":1},"subject_id":null,"timestamp":1564371090,"uuid":"3a8b1c3d-3394-4545-9332-3723f1e530b4"}]
     * page : {"count":3521,"current":1,"size":10,"total":353}
     */

    private int code;
    @JsonProperty("page")
    private PageDto pageDto;
    @JsonProperty("data")
    private List<DataDto> data;

}

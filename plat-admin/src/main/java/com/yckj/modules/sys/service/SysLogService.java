package com.yckj.modules.sys.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yckj.common.utils.PageUtils;
import com.yckj.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 *
 * @author Finder zhangzhili92@163.com
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

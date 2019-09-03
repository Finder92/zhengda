package com.yckj.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yckj.common.utils.PageUtils;
import com.yckj.modules.oss.entity.SysOssEntity;


import java.util.Map;

/**
 * 文件上传
 *
 * @author Finder zhangzhili92@163.com
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}

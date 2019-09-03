package com.yckj.modules.sys.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yckj.common.utils.PageUtils;
import com.yckj.modules.sys.entity.SysDictEntity;

import java.util.Map;

/**
 * 数据字典
 *
 * @author Finder zhangzhili92@163.com
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


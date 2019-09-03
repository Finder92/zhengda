package com.yckj.modules.megvii.controller;

import java.util.Arrays;
import java.util.Map;

import com.yckj.common.utils.PageUtils;
import com.yckj.common.utils.R;
import com.yckj.common.validator.ValidatorUtils;
import com.yckj.modules.megvii.entity.MegAttendDetailEntity;
import com.yckj.modules.megvii.service.MegAttendDetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 
 *
 * @author Finder
 * @email zhangzhili92@163.com
 * @date 2019-08-02 15:40:07
 */
@RestController
@RequestMapping("megvii/megattenddetail")
public class MegAttendDetailController {
    @Autowired
    private MegAttendDetailService megAttendDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("megvii:megattenddetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = megAttendDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("megvii:megattenddetail:info")
    public R info(@PathVariable("id") Long id){
        MegAttendDetailEntity megAttendDetail = megAttendDetailService.getById(id);

        return R.ok().put("megAttendDetail", megAttendDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("megvii:megattenddetail:save")
    public R save(@RequestBody MegAttendDetailEntity megAttendDetail){
        megAttendDetailService.save(megAttendDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("megvii:megattenddetail:update")
    public R update(@RequestBody MegAttendDetailEntity megAttendDetail){
        ValidatorUtils.validateEntity(megAttendDetail);
        megAttendDetailService.updateById(megAttendDetail);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("megvii:megattenddetail:delete")
    public R delete(@RequestBody Long[] ids){
        megAttendDetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

package com.yckj.modules.megvii.controller;

import com.yckj.modules.megvii.service.MegAttendService;
import com.yckj.common.utils.PageUtils;
import com.yckj.common.utils.R;
import com.yckj.common.validator.ValidatorUtils;
import com.yckj.modules.megvii.entity.MegAttendEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author Finder
 * @email zhangzhili92@163.com
 * @date 2019-08-02 15:40:07
 */
@RestController
@RequestMapping("megvii/megattend")
public class MegAttendController {
    @Autowired
    private MegAttendService megAttendService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("megvii:megattend:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = megAttendService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("megvii:megattend:info")
    public R info(@PathVariable("id") Long id){
        MegAttendEntity megAttend = megAttendService.getById(id);

        return R.ok().put("megAttend", megAttend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("megvii:megattend:save")
    public R save(@RequestBody MegAttendEntity megAttend){
        megAttendService.save(megAttend);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("megvii:megattend:update")
    public R update(@RequestBody MegAttendEntity megAttend){
        ValidatorUtils.validateEntity(megAttend);
        megAttendService.updateById(megAttend);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("megvii:megattend:delete")
    public R delete(@RequestBody Long[] ids){
        megAttendService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

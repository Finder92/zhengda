package com.yckj.modules.attend.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yckj.modules.attend.entity.AttendUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author Finder
 * @email zhangzhili92@163.com
 * @date 2019-07-31 14:14:11
 */
@Mapper
public interface AttendUserDao extends BaseMapper<AttendUserEntity> {

    boolean updateSignState(Long attendUserid);

    boolean batchUpdateSignState(List<Long> userId);

    List<AttendUserEntity> queryByAttendUserName(String attendUserName);
}

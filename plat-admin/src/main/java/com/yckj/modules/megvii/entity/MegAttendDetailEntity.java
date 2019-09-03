package com.yckj.modules.megvii.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author Finder
 * @email zhangzhili92@163.com
 * @date 2019-08-02 15:40:07
 */
@Data
@TableName("meg_attend_detail")
public class MegAttendDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 考勤明细主键Id
	 */
	@TableId
	private Long id;
	/**
	 * 公司ID
	 */
	private Long companyId;
	/**
	 * 公司名称
	 */
	private String companyName;
	/**
	 * 部门ID
	 */
	private Long deptId;
	/**
	 * 部门名称
	 */
	private String deptName;
	/**
	 * 员工ID
	 */
	private Long empId;
	/**
	 * 员工姓名
	 */
	private String empName;
	/**
	 * 日期
	 */
	private String date;
	/**
	 * 视频识别时间
	 */
	private String videoTime;
	/**
	 * 监控地点
	 */
	private String place;
	/**
	 * 照片
	 */
	private String photo;
	/**
	 * 视频
	 */
	private String video;

}

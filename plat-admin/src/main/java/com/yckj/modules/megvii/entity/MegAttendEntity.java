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
@TableName("meg_attend")
public class MegAttendEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 考勤报表主键Id
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
	 * 识别时间
	 */
	private String recognized;
	/**
	 * 上班时间
	 */
	private String officeHours;
	/**
	 * 下班时间
	 */
	private String closingTime;

}

package com.zhaowei.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 账号实体类
 * 
 * @author Jackie
 * 
 */
@Data
@Accessors(chain = true)
public class SysUser extends BaseModel implements Serializable {

	private static final long serialVersionUID = -4756645881198820645L;
	
	private String user_id;// 账号ID
	private Dept dept;// 用户所属组织
	private String job_no;// 用户工号
    private String staff_name;// 用户姓名
    private String staff_duty;// 用户职务
    private String staff_sex;// 用户性别
    private String staff_email;// 用户邮箱
    private String staff_phone;// 用户电话

	private String login_name;// 登陆名
	private String password;// 密码
	private String p_salt;// 加密的盐值
	private Integer is_admin;// 是否管理员账号
	private Integer account_state;// 账号状态(0:未登录;1:已登录;2:密码已重置)
	private Date login_time;// 登入时间
	private Date logout_time;// 登出时间
	
	private List<Role> listRole;//角色集合
	private List<String> authList;//权限集合

	private String login_url;//非持久化字段
	private String newPassword;// 非持久化字段（新密码）

}

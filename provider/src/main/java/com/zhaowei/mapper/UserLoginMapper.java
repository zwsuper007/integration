package com.zhaowei.mapper;


import com.zhaowei.entity.SysUser;

/**
 * 登陆接口
 * 
 * @author jackie
 * 
 */
public interface UserLoginMapper {
	/**
	 * 
	 * @param user 账号实体类对象
	 * @return 修改数据条数
	 */
	public int updateUser(SysUser user);
	/**
	 * 
	 * @param loginName 用户登陆名
	 * @return 账号实体类对象
	 */
	public SysUser getUserByName(String loginName);

	/**
	 * 根据登录名获取用户信息（账号、员工、角色）
	 * @param login_name 用户登陆名
	 * @return 账号实体类对象
	 */
	public SysUser getUserInfoByName(String login_name);

}
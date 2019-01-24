package com.zhaowei.mapper;


import com.zhaowei.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SystemRoleMapper {
	/**
	 * 查询角色信息
	 * @param role 角色实体类 
	 * @return 角色实体类结果集列表 
	 */
	public List<Role> query(Role role);
	
	/**
	 * 角色管理新增角色
	 * @param role 角色实体类 
	 * @return 新增数据条数
	 */
	public int add(Role role);
	
	/**
	 * 角色管理修改角色
	 * @param role 角色实体类 
	 * @return 修改数据条数
	 */
	public int edit(Role role);
	
	/**
	 * 角色管理删除角色
	 * @param role 角色实体类 
	 * @return 删除数据条数
	 */
	public int delete(Role role);
	
	/**
	 * 删除授权的关系表信息
	 * @param role_id 角色实体类 id
	 * @return 删除数据条数
	 */
	public int deleteAuthDataDept(String role_id);
	
	/**
	 * 删除角色绑定的授权
	 * @param role 角色实体类 
	 * @return 删除数据条数
	 */
	public int delAuthorizeForRole(Role role);
	
	/**
	 * 通过id查询角色
	 * @param id 角色实体类 id
	 * @return 角色实体类对象
	 */
	public Role queryByID(String id);
	
	/**
	 * 根据角色id获取权限信息
	 * @param role_id 角色实体类 id
	 * @return 所有功能权限id字符串列表
	 */
	public List<String> getChooseAuthority(String role_id);
	
	/**
	 * 为角色设置功能权限
	 * @param role_id 角色实体类 id
	 * @param list 所有功能权限id字符串列表
	 * @return 新增数据条数
	 */
	public int addAuthorityForRole(@Param("role_id") String role_id, @Param("list") List<String> list);
	
	/**
	 * 删除角色绑定的功能权限
	 * @param role_id 角色实体类 id
	 * @return 删除数据条数
	 */
	public int deleteAuthorityForRole(String role_id);
	
	/**
	 * 判断角色名是否唯一
	 * @param role 角色实体类 对象
	 * @return 查询结果数据条数
	 */
	public int checkName(Role role);

	/**
	 * 删除时检查数据是否被引用
	 * @param role_id 角色实体类 对象id
	 * @return 查询结果数据条数
	 */
	public int checkDelete(String role_id);
	
	/**
   * 通过登录名查询角色
   * @param login_name 用户登陆名
   * @return 角色实体类 对象列表
   */
  public List<Role> getRoleByLoginName(String login_name);
  
  /**
   * 通过dept_id查询角色
   * @param dept_id 部门id
   * @return 角色实体类 
   */
  public Role getRoleByDeptId(String dept_id);
  
  /**
   * 通过登录者所属租户id查询角色
   * @param lesseeid 用户所属id
   * @return 角色实体类 对象列表
   */
  public List<Role> queryByLesseeId(String lesseeid);
}
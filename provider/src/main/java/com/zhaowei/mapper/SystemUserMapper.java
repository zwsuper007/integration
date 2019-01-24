package com.zhaowei.mapper;


import com.zhaowei.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemUserMapper {

	/**
	 * 账号管理新增账号
	 * @param sysUser 账号实体类对象
	 * @return 返回新增数据条数
	 */
    public List<SysUser> query(SysUser user);
	/**
	 * 账号管理新增账号
	 * @param sysUser 账号实体类对象
	 * @return 返回新增数据条数
	 */
	public int add(SysUser sysUser);
	
	/**
     * 通过ID查询用户
     * @param userId 用户id
     * @return 查询到的用户
     */
    public SysUser queryById(String userId);
	
	/**
	 * 位账号绑定角色
	 * @param user_id 用户id
	 * @param list 角色id列表
     * @return 返回新增数据条数
	 */
	public int addUserRole(@Param(value = "user_id") String user_id, @Param(value = "list") List<String> list);
	
	/**
	 * 账号管理修改账号
	 * @param sysUser 账号实体类对象
     * @return 返回修改数据条数
	 */
	public int edit(SysUser sysUser);
	
	 /**
	  * 重置密码
	  * @param sysUser 账号实体类对象
      * @return 返回修改数据条数
	  */
	public int resetPassword(SysUser sysUser);
	
	/**
     * 启用/禁用账号
     * @param sysUser 账号实体类对象
     * @return 返回修改数据条数
     */
    public int accountState(SysUser sysUser);
    
	/**
	 * 账号管理删除账号
	 * @param sysUser 账号实体类对象
     * @return 返回删除数据条数
	 */
	public int delete(SysUser sysUser);
	
	/**
	 * 通过deptId查询租户访问路径信息
	 * @param deptId
	 * @return
	 */
	public String queryByDeptId(String deptId);
	
	/**
	 * 根据用户信息获取角色
	 * @param user_id 用户id
     * @return 角色id列表
	 */
	public List<String> getChooseRole(String user_id);
	
	/**
	 * 根据登陆名获取账号信息
	 * @param login_name 用户登陆名
     * @return 查询结果条数
	 */
	public int checkLoginName(String login_name);
	
	/**
	 * 删除用户绑定的角色
	 * @param user_id 用户id
     * @return 删除数据条数
	 */
	public int deleteUserRoleByUserId(String user_id);
	
	/**
   * 通过user_id删除用户绑定的角色
   * @param user_id 用户id
   * @return 删除数据条数
   */
  public int deleteUserRole(String user_id);
  
  /**
   * 通过组织ID查询用户信息
   * @param deptId 组织ID
   * @return 当前部门下用户的数量
   */
  public int queryUserByDeptID(String deptId);
  
  /**
   * 通过登录名查询用户
   * @param username 登录名
   * @return 用户
   */
  public SysUser selectUserByLoginName(String username);

  public List<SysUser> queryByBelongDeptId(String belongDeptId);

}
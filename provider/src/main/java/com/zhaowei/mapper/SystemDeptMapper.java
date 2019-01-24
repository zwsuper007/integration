package com.zhaowei.mapper;


import com.zhaowei.entity.Dept;

import java.util.List;
import java.util.Map;


/**
 * 组织架构的接口类
 * @author jackie
 *
 */
public interface SystemDeptMapper {
	
	/**
	 * 查询各级部门是否存在
	 * @param dept 组织架构实体类
	 * @return Long 返回查询结果条数
	 */
	public int checkName(Dept dept);
	
	/**
	 * 组织架构新增部门
	 * @param dept 组织架构实体类
	 * @return int 返回新增数据条数
	 */
	public int add(Dept dept);
	
	/**
	 * 插入组织关系
	 * @param param 组织关系数据
	 * @return Integer 返回插入数据条数
	 */
	public Integer insertDeptRedundancy(Map<String, Object> param);
	
	/**
	 * 组织架构修改部门
	 * @param dept 组织架构实体类
	 */
	public int edit(Dept dept);
	
	/**
	 * 组织架构删除部门
	 * @param dept 组织架构实体类
	 * @return int 返回删除数据条数
	 */
	public int delete(Dept dept);
	
	/**
	 * 删除部门的冗余关系
	 * @param dept_id 组织架构实体类id
	 * @return int 返回删除数据条数
	 */
	public int deleteRedundancy(String dept_id);
	
	/**
   * 查询组织是否被数据权限使用
   * @param dept_id 组织架构实体类id
   * @return int 返回查询数据条数
   */
  public int checkForData(String dept_id);
	
	/**
	 * 查询组织架构中租户所包含部门
	 * @return 返回组织架构实体类的结果集
	 */
	public List<Dept> query();
	
	/**
	 * 通过ID查询组织架构信息
	 * @param id 组织架构实体类id
	 * @return 组织架构实体类
	 */
	public Dept queryByID(String id);

	/**
   * 根据组织ID获取本级及下级组织信息
   * @param dept_id 组织架构实体类id
   * @return 本级组织以及所有下级组织的id
   */
  public List<String> querySubDeptByID(String dept_id);

  	/**
	 * 查询租户下所包含部门
	 * zhaowei
	 * @return 返回组织架构实体类的结果集
	 */
	public List<Dept> queryAll();

	
	/**
	 * 通过ID查询组织架构信息
	 * zhaowei
	 * @param id 组织架构实体类id
	 * @return 组织架构实体类
	 */
	public Dept myQueryByID(String id);

	/**
	 * 通过dept_code查询组织架构信息
	 * zhaowei
	 * @param id 组织架构实体类dept_code
	 * @return 组织架构实体类
	 */
	public Dept queryByCode(String dept_code);

	public List<Dept> queryBusiness();

	public Integer checkByDeptCode(String dept_code);

}
package com.zhaowei.entity;

import java.io.Serializable;


/**
 * 角色实体类 
 * @author Jackie
 * 
 */
public class Role extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role_id;// 角色ID
	private String role_name;// 角色名称
	private Integer is_admin;// 是否为管理员角色 1：是；0：否

	public String arrID;

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Integer getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(Integer is_admin) {
		this.is_admin = is_admin;
	}

	public String getArrID() {
		return arrID;
	}

	public void setArrID(String arrID) {
		this.arrID = arrID;
	}

}

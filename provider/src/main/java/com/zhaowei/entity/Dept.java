package com.zhaowei.entity;

import java.io.Serializable;

/**
 * 组织架构实体类
 * @author Jackie
 *
 */
public class Dept extends BaseModel implements Serializable{
	
	private static final long serialVersionUID = -3600080980949437798L;
	private String dept_id;// 组织ID
	private String dept_full_name;//组织名称
	private String dept_name;//组织名称
	private String dept_code;//组织编码
	private String dept_addr;//组织地址
	private String dept_linkman;//组织联系人
	private String dept_linkman_phone;//联系电话
	private String dept_linkman_email;//电子邮件
	private Dept pre_dept;// 组织父ID
	private Integer hasChild;//组织是否有子节点
	private Integer d_level;//组织节点级别
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_full_name() {
		return dept_full_name;
	}
	public void setDept_full_name(String dept_full_name) {
		this.dept_full_name = dept_full_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getDept_addr() {
		return dept_addr;
	}
	public void setDept_addr(String dept_addr) {
		this.dept_addr = dept_addr;
	}
	public String getDept_linkman() {
		return dept_linkman;
	}
	public void setDept_linkman(String dept_linkman) {
		this.dept_linkman = dept_linkman;
	}
	public String getDept_linkman_phone() {
		return dept_linkman_phone;
	}
	public void setDept_linkman_phone(String dept_linkman_phone) {
		this.dept_linkman_phone = dept_linkman_phone;
	}
	public String getDept_linkman_email() {
		return dept_linkman_email;
	}
	public void setDept_linkman_email(String dept_linkman_email) {
		this.dept_linkman_email = dept_linkman_email;
	}
	public Dept getPre_dept() {
		return pre_dept;
	}
	public void setPre_dept(Dept pre_dept) {
		this.pre_dept = pre_dept;
	}
	public Integer getHasChild() {
		return hasChild;
	}
	public void setHasChild(Integer hasChild) {
		this.hasChild = hasChild;
	}
	public Integer getD_level() {
		return d_level;
	}
	public void setD_level(Integer d_level) {
		this.d_level = d_level;
	}
}

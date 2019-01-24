package com.zhaowei.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体表基础字段（ 分页、排序、搜索信息；数据库基础字段；数据权限；租户）
 * @author jackie
 *
 */
public abstract class BaseModel implements Serializable{

	private static final long serialVersionUID = -7773253052553142952L;
	protected int startRow; // 用于翻页 起始位置
	protected int pageSize; // 用于翻页 每页记录数
	protected String sortDirection; // 用于排序 排序方式
	protected String sortCriterion; // 用于排序 排序列
	protected String sortSql; //用于多列排序
	
	protected String createUser; //创建人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createTime; //创建时间
	protected String updateUser; //修改人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date updateTime; //修改时间
	protected Integer state; // 状态--  1：创建 ， 2：修改， -1：删除
	protected String memo; // 备注
	
	protected String belongDeptId; // 数据所属组织ID
	protected String belongLesseeId; // 数据所属租户ID
	private String jsonInfo; // 借用临时字段

    public String getJsonInfo() {
        return jsonInfo;
    }

    public void setJsonInfo(String jsonInfo) {
        this.jsonInfo = jsonInfo;
    }
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortDirection() {
		return sortDirection;
	}
	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}
	public String getSortCriterion() {
		return sortCriterion;
	}
	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}
	public String getSortSql() {
		return sortSql;
	}
	public void setSortSql(String sortSql) {
		this.sortSql = sortSql;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getBelongDeptId() {
		return belongDeptId;
	}
	public void setBelongDeptId(String belongDeptId) {
		this.belongDeptId = belongDeptId;
	}
	public String getBelongLesseeId() {
		return belongLesseeId;
	}
	public void setBelongLesseeId(String belongLesseeId) {
		this.belongLesseeId = belongLesseeId;
	}
}

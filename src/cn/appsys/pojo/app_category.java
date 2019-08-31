package cn.appsys.pojo;

import java.math.BigInteger;
import java.util.Date;

public class app_category {
	private BigInteger id;
	private String categoryCode; // 分类编号
	private String categoryName; // 分类名称
	private BigInteger parentId; // 夫类节点id
	private BigInteger createdBy;// 创建者
	private Date creationTime; // 创建时间
	private BigInteger modifyBy;// 更新者
	private Date modifyDate; // 更新时间

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BigInteger getParentId() {
		return parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}

	public BigInteger getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public BigInteger getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(BigInteger modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}

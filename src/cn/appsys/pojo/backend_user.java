package cn.appsys.pojo;

import java.math.BigInteger;
import java.util.Date;

public class backend_user {
	private BigInteger id;
	private String userCode; // 用户编号
	private String userName;// 用户名称
	private BigInteger userType;// 用户角色类型
	private BigInteger createdBy;// 创建者
	private Date creationDate; // 创建时间
	private BigInteger modifyBy; // 更新者
	private Date modifyDate; // 更新时间
	private String userPassword; // 用户密码
	private String userTypeName;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigInteger getUserType() {
		return userType;
	}

	public void setUserType(BigInteger userType) {
		this.userType = userType;
	}

	public BigInteger getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
}

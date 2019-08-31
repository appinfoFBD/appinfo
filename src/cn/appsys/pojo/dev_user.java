package cn.appsys.pojo;

import java.math.BigInteger;
import java.util.Date;
/**
 * 开发者用户
 * @author 侯大胆
 *
 */
public class dev_user {
	private BigInteger id;
	private String devCode; // 开发者账号
	private String devName; // 开发者名称
	private String devPassword;// 开发者密码
	private String devEmail; // 开发者电子邮箱
	private String devInfo; // 开发者简介
	private BigInteger createdBy;// 创建者
	private Date creationDate; // 创建时间
	private BigInteger modifyBy; // 更新者
	private Date modifyDate; // 更新时间

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getDevPassword() {
		return devPassword;
	}

	public void setDevPassword(String devPassword) {
		this.devPassword = devPassword;
	}

	public String getDevEmail() {
		return devEmail;
	}

	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}

	public String getDevInfo() {
		return devInfo;
	}

	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
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

}

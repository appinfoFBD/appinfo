package cn.appsys.pojo;

import java.math.BigInteger;
import java.util.Date;


public class app_version {
	private BigInteger id;
	private BigInteger appId;
	private String versionNo; // 版本号
	private String versionInfo; // 版本介绍
	private BigInteger publishStatus;// 发布状态
	private String downloadLink; // 下载链接
	private Double versionSize; // 版本大小
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

	public BigInteger getAppId() {
		return appId;
	}

	public void setAppId(BigInteger appId) {
		this.appId = appId;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public BigInteger getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(BigInteger publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public Double getVersionSize() {
		return versionSize;
	}

	public void setVersionSize(Double versionSize) {
		this.versionSize = versionSize;
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

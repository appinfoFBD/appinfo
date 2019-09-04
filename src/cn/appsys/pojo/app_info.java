package cn.appsys.pojo;

import java.math.BigInteger;
import java.util.Date;

public class app_info {
	private BigInteger id;
	private String softwareName; // 软件名称
	private String APKName; // apk名称
	private String supportROM;// 支持ROM
	private String interfaceLanguage;// 界面语言
	private Double softwareSize; // 软件大小
	private Date updateDate; // 更新日期
	private BigInteger devId; // 开发者id
	private String appInfo; // 应用简介
	private BigInteger status;// 状态
	private Date onSaleDate; // 上架时间
	private BigInteger createdBy; // 创建者
	private Date creationDate; // 创建时间
	private String logoPicPath;
	private String logoLocPath;
	private BigInteger flatformId;
	private String flatformName;
	private String downloads;
	private BigInteger versionId;
	private BigInteger categoryLevel1;
	private BigInteger categoryLevel2;
	private BigInteger categoryLevel3;

	public BigInteger getVersionId() {
		return versionId;
	}

	public void setVersionId(BigInteger versionId) {
		this.versionId = versionId;
	}

	private String categoryLevel2Name;
	private String categoryLevel3Name;
	private String statusName;
	private String versionNo;

	public String getFlatformName() {
		return flatformName;
	}

	public void setFlatformName(String flatformName) {
		this.flatformName = flatformName;
	}

	private String categoryLevel1Name;

	public String getCategoryLevel1Name() {
		return categoryLevel1Name;
	}

	public void setCategoryLevel1Name(String categoryLevel1Name) {
		this.categoryLevel1Name = categoryLevel1Name;
	}

	public String getCategoryLevel2Name() {
		return categoryLevel2Name;
	}

	public void setCategoryLevel2Name(String categoryLevel2Name) {
		this.categoryLevel2Name = categoryLevel2Name;
	}

	public String getCategoryLevel3Name() {
		return categoryLevel3Name;
	}

	public void setCategoryLevel3Name(String categoryLevel3Name) {
		this.categoryLevel3Name = categoryLevel3Name;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getAPKName() {
		return APKName;
	}

	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}

	public String getSupportROM() {
		return supportROM;
	}

	public void setSupportROM(String supportROM) {
		this.supportROM = supportROM;
	}

	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}

	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}

	public Double getSoftwareSize() {
		return softwareSize;
	}

	public void setSoftwareSize(Double softwareSize) {
		this.softwareSize = softwareSize;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public BigInteger getDevId() {
		return devId;
	}

	public void setDevId(BigInteger devId) {
		this.devId = devId;
	}

	public String getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}

	public BigInteger getStatus() {
		return status;
	}

	public void setStatus(BigInteger status) {
		this.status = status;
	}

	public Date getOnSaleDate() {
		return onSaleDate;
	}

	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}

	public String getDownloads() {
		return downloads;
	}

	public void setDownloads(String downloads) {
		this.downloads = downloads;
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

	public String getLogoPicPath() {
		return logoPicPath;
	}

	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}

	public String getLogoLocPath() {
		return logoLocPath;
	}

	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}

	public BigInteger getFlatformId() {
		return flatformId;
	}

	public void setFlatformId(BigInteger flatformId) {
		this.flatformId = flatformId;
	}

	public BigInteger getCategoryLevel1() {
		return categoryLevel1;
	}

	public void setCategoryLevel1(BigInteger categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}

	public BigInteger getCategoryLevel2() {
		return categoryLevel2;
	}

	public void setCategoryLevel2(BigInteger categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}

	public BigInteger getCategoryLevel3() {
		return categoryLevel3;
	}

	public void setCategoryLevel3(BigInteger categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
}

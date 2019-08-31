package cn.appsys.pojo;

import java.math.BigInteger;
import java.util.Date;

public class ad_promotion {
	private BigInteger id;
	private BigInteger appId;
	private String adPicPath;// 广告图片储存路径
	private BigInteger adPV; // 广告点击量
	private int carouselPosition;// 轮播位
	private Date startTime;// 起效时间
	private Date endTime; // 失效时间
	private BigInteger createdBy;// 创建者
	private Date creationDate; // 创建时间
	private BigInteger modifyBy;// 更新者
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

	public String getAdPicPath() {
		return adPicPath;
	}

	public void setAdPicPath(String adPicPath) {
		this.adPicPath = adPicPath;
	}

	public BigInteger getAdPV() {
		return adPV;
	}

	public void setAdPV(BigInteger adPV) {
		this.adPV = adPV;
	}

	public int getCarouselPosition() {
		return carouselPosition;
	}

	public void setCarouselPosition(int carouselPosition) {
		this.carouselPosition = carouselPosition;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

package cn.appsys.pojo;

import java.math.BigInteger;
import java.util.Date;

public class ad_promotion {
	private BigInteger id;
	private BigInteger appId;
	private String adPicPath;// ���ͼƬ����·��
	private BigInteger adPV; // �������
	private int carouselPosition;// �ֲ�λ
	private Date startTime;// ��Чʱ��
	private Date endTime; // ʧЧʱ��
	private BigInteger createdBy;// ������
	private Date creationDate; // ����ʱ��
	private BigInteger modifyBy;// ������
	private Date modifyDate; // ����ʱ��

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

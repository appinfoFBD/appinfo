package cn.appsys.pojo;

import java.math.BigInteger;
import java.util.Date;

public class data_dictionary {
	private BigInteger id;
	private String typeCode;// ���ͱ���
	private String typeName;// ��������
	private BigInteger valueId;// ����ֵID
	private String valueName; // ����ֵ����
	private BigInteger createdBy;// ������
	private Date creationDate; // ����ʱ��
	private BigInteger modifyBy; // ������
	private Date modifyDate; // ����ʱ��

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public BigInteger getValueId() {
		return valueId;
	}

	public void setValueId(BigInteger valueId) {
		this.valueId = valueId;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
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

package cn.appsys.dao.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_version;

public interface versionMapper {
	// �����汾
	public int insertVersion(app_version version);

	// ����������id
	public int returnId();

	// ��ѯ���°汾��Ϣ
	public app_version selectVersion(@Param("versionId") Integer versionId, @Param("appInfoId") Integer appInfoId);
	//�޸İ汾
	public int updateVersion(app_version version);
	//��ѯappId�����а汾
	public List<app_version> versionList(@Param("appId") Integer appId);
	//ɾ��app����ʷ�汾��Ϣ
	public int delectVersion(@Param("appId")Integer appId);
}

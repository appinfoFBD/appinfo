package cn.appsys.dao.developer;

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
}

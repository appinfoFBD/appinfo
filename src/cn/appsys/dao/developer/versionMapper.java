package cn.appsys.dao.developer;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_version;

public interface versionMapper {
	// 新增版本
	public int insertVersion(app_version version);

	// 返回新增的id
	public int returnId();

	// 查询最新版本信息
	public app_version selectVersion(@Param("versionId") Integer versionId, @Param("appInfoId") Integer appInfoId);
	//修改版本
	public int updateVersion(app_version version);
}

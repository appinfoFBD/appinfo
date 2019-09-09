package cn.appsys.dao.developer;

import java.util.List;

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
	//查询appId的所有版本
	public List<app_version> versionList(@Param("appId") Integer appId);
	//删除app的历史版本信息
	public int delectVersion(@Param("appId")Integer appId);
}

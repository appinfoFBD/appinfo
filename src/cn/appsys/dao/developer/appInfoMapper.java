package cn.appsys.dao.developer;

import java.util.List;

import javax.validation.constraints.Past;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_info;

public interface appInfoMapper {
	// 查询app应用
	public List<app_info> selectAppInfo(@Param("softwareName") String softwareName, @Param("status") Integer status,
			@Param("flatformId") Integer flatformId, @Param("categoryLevel1") Integer categoryLevel1,
			@Param("categoryLevel2") Integer categoryLevel2, @Param("categoryLevel3") Integer categoryLevel3,
			@Param("pageIndex") Integer pageIndex, @Param("pageConut") Integer pageConut);

	// 查询app的总条数
	public int count(@Param("softwareName") String softwareName,
            @Param("status") Integer status,
            @Param("flatformId") Integer flatformId,
            @Param("categoryLevel1") Integer categoryLevel1,
            @Param("categoryLevel2") Integer categoryLevel2,
            @Param("categoryLevel3") Integer categoryLevel3);
	//添加app信息
	public int appAdd(app_info app);
	//按添加查询
	public app_info findApp(@Param("APKName")String APKName,@Param("id") Integer id);
	//按id查找app的信息
	public app_info findAppId(@Param("id")Integer id);
	//修改app信息
	public int appinfomodify(app_info app);
	//查询app的版本
	public app_info selectVersion(@Param("id")Integer id);
	//更新版本id
	public int updateVersionId(@Param("id")Integer id,@Param("versionId")Integer versionId);
	//删除app信息
	public int delectApp(@Param("id")Integer id);
}

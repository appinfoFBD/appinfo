package cn.appsys.dao.developer;

import java.util.List;

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
	public app_info findApp(@Param("APKName")String APKName);
	//按id查找app的信息
	public app_info findAppId(@Param("id")Integer id);
	//修改app信息
	public int appinfomodify(app_info app);
}

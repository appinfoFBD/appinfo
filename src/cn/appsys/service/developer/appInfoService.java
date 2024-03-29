package cn.appsys.service.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_info;

public interface appInfoService {
	// 分页查询
	public List<app_info> selectAppInfo(@Param("softwareName") String softwareName, @Param("status") Integer status,
			@Param("flatformId") Integer flatformId, @Param("categoryLevel1") Integer categoryLevel1,
			@Param("categoryLevel2") Integer categoryLevel2, @Param("categoryLevel3") Integer categoryLevel3,
			@Param("pageIndex") Integer pageIndex, @Param("pageConut") Integer pageConut);

	// 获取app总数
	public int count(@Param("softwareName") String softwareName, @Param("status") Integer status,
			@Param("flatformId") Integer flatformId, @Param("categoryLevel1") Integer categoryLevel1,
			@Param("categoryLevel2") Integer categoryLevel2, @Param("categoryLevel3") Integer categoryLevel3);
	//添加app信息
	public boolean appAdd(app_info app);
	//验证PAK是否存在
	public app_info findApp(String PAKName);
	//修改操作
	public boolean appinfomodify(app_info app);
	//按id查找app信息
	public app_info findAppInfo(Integer id);
	//查询app版本信息
	public app_info selectAppVersion(int id);
	//按id查找apk名称
	public app_info findAPKName(Integer id);
	//删除app操作
	public boolean delectApp(app_info appInfo,Integer id);
}

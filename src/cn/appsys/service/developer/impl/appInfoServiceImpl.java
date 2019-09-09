package cn.appsys.service.developer.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.developer.appInfoMapper;
import cn.appsys.dao.developer.versionMapper;
import cn.appsys.pojo.app_info;
import cn.appsys.pojo.app_version;
import cn.appsys.service.developer.appInfoService;

@Service("appInfoService")
public class appInfoServiceImpl implements appInfoService {
	@Autowired
	private appInfoMapper appinfoMapper;
	@Autowired
	private versionMapper versionMapper;

	@Override
	public List<app_info> selectAppInfo(String softwareName, Integer status, Integer flatformId, Integer categoryLevel1,
			Integer categoryLevel2, Integer categoryLevel3, Integer pageIndex, Integer pageConut) {
		return appinfoMapper.selectAppInfo(softwareName, status, flatformId, categoryLevel1, categoryLevel2,
				categoryLevel3, pageIndex, pageConut);
	}

	@Override
	public int count(String softwareName, Integer status, Integer flatformId, Integer categoryLevel1,
			Integer categoryLevel2, Integer categoryLevel3) {
		return appinfoMapper.count(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
	}

	@Override
	public boolean appAdd(app_info app) {
		if (appinfoMapper.appAdd(app) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public app_info findApp(String PAKName) {
		return appinfoMapper.findApp(PAKName, null);
	}

	@Override
	public boolean appinfomodify(app_info app) {
		if (appinfoMapper.appinfomodify(app) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public app_info findAppInfo(Integer id) {
		return appinfoMapper.findAppId(id);
	}

	@Override
	public app_info selectAppVersion(int id) {
		return appinfoMapper.selectVersion(id);
	}

	@Override
	public app_info findAPKName(Integer id) {
		return appinfoMapper.findApp(null, id);
	}

	@Override
	public boolean delectApp(app_info appInfo,Integer id) {
		File file = null;
			// 先删除App的资源
			file = new File(appInfo.getLogoLocPath());
			if (file.exists()) {
				file.delete();
			}
			// 查询所有的版本
			List<app_version> versionList = versionMapper.versionList(appInfo.getId());
			for (int i = 0; i < versionList.size(); i++) {
				file = new File(versionList.get(i).getApkLocPath());
				if (file.exists()) {
					file.delete();
				}
			}
			// 删除数据库信息
			int result = appinfoMapper.delectApp(appInfo.getId());
			if (result > 0) {
				// 删除版本信息
				if(appInfo.getVersionId()!=null){
					result = versionMapper.delectVersion(appInfo.getId());
				}
				return true;
				
			}
		return false;
	}

}

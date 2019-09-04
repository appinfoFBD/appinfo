package cn.appsys.service.developer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.developer.appInfoMapper;
import cn.appsys.pojo.app_info;
import cn.appsys.service.developer.appInfoService;

@Service("appInfoService")
public class appInfoServiceImpl implements appInfoService {
	@Autowired
	private appInfoMapper appinfoMapper;

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
		if(appinfoMapper.appAdd(app)>0){
			return true;
		}
		return false;
	}

	@Override
	public app_info findApp(String PAKName) {
		return appinfoMapper.findApp(PAKName);
	}

}

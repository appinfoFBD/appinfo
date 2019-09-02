package cn.appsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.appInfoMapper;
import cn.appsys.pojo.app_info;
import cn.appsys.service.appInfoService;
@Service("appInfoService")
public class appInfoServiceImpl implements appInfoService {
	@Autowired
    private appInfoMapper appinfoMapper;
	@Override
	public List<app_info> selectAppInfo(String softwareName, Integer status, Integer flatformId, Integer categoryLevel1,
			Integer categoryLevel2, Integer categoryLevel3, Integer pageIndex, Integer pageConut) {
		return appinfoMapper.selectAppInfo(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, pageIndex, pageConut);
	}
    
	@Override
	public int count(String softwareName, Integer status, Integer flatformId, Integer categoryLevel1,
			Integer categoryLevel2, Integer categoryLevel3) {
		return appinfoMapper.count(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
	}

}

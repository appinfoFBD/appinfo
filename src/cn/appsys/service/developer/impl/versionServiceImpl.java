package cn.appsys.service.developer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.developer.appInfoMapper;
import cn.appsys.dao.developer.versionMapper;
import cn.appsys.pojo.app_version;
import cn.appsys.service.developer.versionService;
@Service("versionService")
public class versionServiceImpl implements versionService {
    @Autowired
	private versionMapper versionMapper;
    @Autowired
    private appInfoMapper appInfoMapper;
	@Override
	public boolean insertVersion(app_version version) {
		if(versionMapper.insertVersion(version)>0){
			Integer versionId=versionMapper.returnId();
			appInfoMapper.updateVersionId(version.getAppId(), versionId);
			return true;
		}
		return false;
	}
	@Override
	public app_version selectVersion(Integer versionId, Integer appInfoId) {
		return versionMapper.selectVersion(versionId, appInfoId);
	}
	public boolean updateVersion(app_version version) {
		if(versionMapper.updateVersion(version)>0){
			return true;
		}
		return false;
	}
	@Override
	public List<app_version> versionList(Integer appId) {
		return versionMapper.versionList(appId);
	}


}

package cn.appsys.service.developer.impl;

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

}

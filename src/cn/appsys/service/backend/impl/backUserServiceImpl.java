package cn.appsys.service.backend.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backend.backUserMapper;
import cn.appsys.pojo.backend_user;
import cn.appsys.service.backend.backUserService;
@Service("backUserService")
public class backUserServiceImpl implements backUserService{
	@Resource(name="backUserMapper")
	
	private backUserMapper backuserMapper;
	
	@Override
	public backend_user doLoing(String userCode) {
		return backuserMapper.doLoing(userCode);
	}
}

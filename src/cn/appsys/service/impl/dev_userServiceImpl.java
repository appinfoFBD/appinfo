package cn.appsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.dev_userMapper;
import cn.appsys.pojo.dev_user;
import cn.appsys.service.dev_userService;
@Service("dev_userService")
public class dev_userServiceImpl implements dev_userService {
	@Autowired
	private dev_userMapper dev_userMapper;

	@Override
	public dev_user findLogin(String devCode) {
		return dev_userMapper.findLogin(devCode);
	}

}

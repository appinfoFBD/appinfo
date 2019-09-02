package cn.appsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.userMapper;
import cn.appsys.pojo.dev_user;
import cn.appsys.service.userService;
@Service("userService")
public class userServiceImpl implements userService {
	@Autowired
	private userMapper userMapper;

	@Override
	public dev_user findLogin(String devCode) {
		return userMapper.findLogin(devCode);
	}

}

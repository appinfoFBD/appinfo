package cn.appsys.dao.backend;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.backend_user;

public interface backUserMapper {
	
    //登录
	public backend_user doLoing(@Param("userCode")String userName);
}

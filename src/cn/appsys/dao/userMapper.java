package cn.appsys.dao;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.dev_user;

public interface userMapper {
    //µÇÂ¼µÄ·½·¨
	public dev_user findLogin(@Param("devCode")String devCode);
}

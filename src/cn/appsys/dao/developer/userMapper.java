package cn.appsys.dao.developer;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.dev_user;

public interface userMapper {
    //��¼�ķ���
	public dev_user findLogin(@Param("devCode")String devCode);
}

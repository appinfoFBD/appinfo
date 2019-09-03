package cn.appsys.dao.developer;

import java.util.List;

import cn.appsys.pojo.data_dictionary;

public interface dictionaryMapper {
    //查询app的状态
	public List<data_dictionary> selectAppstatus();
	//查询app所属平台
	public List<data_dictionary> selectApp_flatform();
}

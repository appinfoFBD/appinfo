package cn.appsys.dao.developer;

import java.util.List;

import cn.appsys.pojo.data_dictionary;

public interface dictionaryMapper {
    //��ѯapp��״̬
	public List<data_dictionary> selectAppstatus();
	//��ѯapp����ƽ̨
	public List<data_dictionary> selectApp_flatform();
}

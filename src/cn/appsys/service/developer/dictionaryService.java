package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.data_dictionary;

public interface dictionaryService {
   //查询app状态
   public List<data_dictionary> selectAppstatus();
   //查询app所属平台 
   public List<data_dictionary> selectApp_flatform();
}

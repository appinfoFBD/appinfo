package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.data_dictionary;

public interface dictionaryService {
   //��ѯapp״̬
   public List<data_dictionary> selectAppstatus();
   //��ѯapp����ƽ̨ 
   public List<data_dictionary> selectApp_flatform();
}

package cn.appsys.dao.developer;

import cn.appsys.pojo.app_version;

public interface versionMapper {
      //新增版本
	  public int insertVersion(app_version version);
	  
	  //返回新增的id
	  public int returnId();
}

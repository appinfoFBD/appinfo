package cn.appsys.dao.developer;

import cn.appsys.pojo.app_version;

public interface versionMapper {
      //�����汾
	  public int insertVersion(app_version version);
	  
	  //����������id
	  public int returnId();
}

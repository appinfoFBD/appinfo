package cn.appsys.service.developer;

import cn.appsys.pojo.app_version;

public interface versionService {
    public boolean insertVersion(app_version version);
    //查询版本信息
    public app_version selectVersion(Integer versionId,Integer appInfoId);
    //修改版本信息
    public boolean updateVersion(app_version version);
}

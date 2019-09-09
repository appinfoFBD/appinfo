package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.app_version;

public interface versionService {
    public boolean insertVersion(app_version version);
    //查询版本信息
    public app_version selectVersion(Integer versionId,Integer appInfoId);
    //修改版本信息
    public boolean updateVersion(app_version version);
    //查询appId的所有版本信息
    public List<app_version> versionList(Integer appId);
}

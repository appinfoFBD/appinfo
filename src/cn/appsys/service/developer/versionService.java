package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.app_version;

public interface versionService {
    public boolean insertVersion(app_version version);
    //��ѯ�汾��Ϣ
    public app_version selectVersion(Integer versionId,Integer appInfoId);
    //�޸İ汾��Ϣ
    public boolean updateVersion(app_version version);
    //��ѯappId�����а汾��Ϣ
    public List<app_version> versionList(Integer appId);
}

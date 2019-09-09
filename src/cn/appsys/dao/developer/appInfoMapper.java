package cn.appsys.dao.developer;

import java.util.List;

import javax.validation.constraints.Past;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_info;

public interface appInfoMapper {
	// ��ѯappӦ��
	public List<app_info> selectAppInfo(@Param("softwareName") String softwareName, @Param("status") Integer status,
			@Param("flatformId") Integer flatformId, @Param("categoryLevel1") Integer categoryLevel1,
			@Param("categoryLevel2") Integer categoryLevel2, @Param("categoryLevel3") Integer categoryLevel3,
			@Param("pageIndex") Integer pageIndex, @Param("pageConut") Integer pageConut);

	// ��ѯapp��������
	public int count(@Param("softwareName") String softwareName,
            @Param("status") Integer status,
            @Param("flatformId") Integer flatformId,
            @Param("categoryLevel1") Integer categoryLevel1,
            @Param("categoryLevel2") Integer categoryLevel2,
            @Param("categoryLevel3") Integer categoryLevel3);
	//���app��Ϣ
	public int appAdd(app_info app);
	//����Ӳ�ѯ
	public app_info findApp(@Param("APKName")String APKName,@Param("id") Integer id);
	//��id����app����Ϣ
	public app_info findAppId(@Param("id")Integer id);
	//�޸�app��Ϣ
	public int appinfomodify(app_info app);
	//��ѯapp�İ汾
	public app_info selectVersion(@Param("id")Integer id);
	//���°汾id
	public int updateVersionId(@Param("id")Integer id,@Param("versionId")Integer versionId);
	//ɾ��app��Ϣ
	public int delectApp(@Param("id")Integer id);
}

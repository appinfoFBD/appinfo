package cn.appsys.dao.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_category;

public interface categoryMapper {
     //��ѯһ������
	 public List<app_category> selectCategory1();
	 //��ԃ�ˆ�
	 public List<app_category> selectCategory(@Param("parentId") Integer parentId);
	 
}

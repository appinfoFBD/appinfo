package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.app_category;

public interface categoryService {
	 //��ȡһ���˵�
     public List<app_category> selectCategory1();
     //��ȡ�˵�����
     public List<app_category> selectCategory(Integer parentId);
}

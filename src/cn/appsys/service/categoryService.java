package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.app_category;

public interface categoryService {
	 //获取一级菜单
     public List<app_category> selectCategory1();
     //获取菜单分类
     public List<app_category> selectCategory(Integer parentId);
}

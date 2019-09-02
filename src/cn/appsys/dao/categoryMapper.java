package cn.appsys.dao;

import java.util.List;

import cn.appsys.pojo.app_category;

public interface categoryMapper {
     //查询一级分类
	 public List<app_category> selectCategory1();
}

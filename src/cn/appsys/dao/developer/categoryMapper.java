package cn.appsys.dao.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_category;

public interface categoryMapper {
     //查询一级分类
	 public List<app_category> selectCategory1();
	 //查詢菜單
	 public List<app_category> selectCategory(@Param("parentId") Integer parentId);
	 
}

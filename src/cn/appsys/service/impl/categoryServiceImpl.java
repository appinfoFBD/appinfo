package cn.appsys.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.categoryMapper;
import cn.appsys.pojo.app_category;
import cn.appsys.service.categoryService;
@Service("categoryService")
public class categoryServiceImpl implements categoryService {
	@Resource(name="categoryMapper")
	private categoryMapper categoryMapper;

	@Override
	public List<app_category> selectCategory1() {
		return categoryMapper.selectCategory1();
	}

	@Override
	public List<app_category> selectCategory(Integer parentId) {
		return categoryMapper.selectCategory(parentId);
	}

}

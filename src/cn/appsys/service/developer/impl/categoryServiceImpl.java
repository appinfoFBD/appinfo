package cn.appsys.service.developer.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.appsys.pojo.app_category;
import cn.appsys.service.developer.categoryService;
import cn.appsys.dao.developer.*;
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
		if(parentId==null){
			return categoryMapper.selectCategory1();
		}
		return categoryMapper.selectCategory(parentId);
	}

}

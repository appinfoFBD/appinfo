package cn.appsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.dictionaryMapper;
import cn.appsys.pojo.data_dictionary;
import cn.appsys.service.dictionaryService;
@Service("dictionaryService")
public class dictionaryServiceImpl implements dictionaryService {
	@Autowired
	private dictionaryMapper dictionaryMapper;

	@Override
	public List<data_dictionary> selectAppstatus() {
		return dictionaryMapper.selectAppstatus();
	}

	@Override
	public List<data_dictionary> selectApp_flatform() {
		return dictionaryMapper.selectApp_flatform();
	}

}

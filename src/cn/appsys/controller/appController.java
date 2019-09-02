package cn.appsys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.appsys.pojo.app_category;
import cn.appsys.pojo.app_info;
import cn.appsys.pojo.data_dictionary;
import cn.appsys.service.appInfoService;
import cn.appsys.service.categoryService;
import cn.appsys.service.dictionaryService;
import cn.appsys.tools.Pager;

@Controller
@RequestMapping("/devApp")
public class appController {
	@Resource(name = "categoryService")
	// app菜单分类
	private categoryService categoryService;
	// app状态
	@Resource(name = "dictionaryService")
	private dictionaryService dictionaryService;
	//app信息
	@Resource(name="appInfoService")
	private appInfoService appInfoService;

	// app查询列表
	@RequestMapping("/flatform")
	public ModelAndView appList(@RequestParam(value = "querySoftwareName", required = false) String querySoftwareName,
			@RequestParam(value = "queryStatus", required = false) Integer queryStatus,
			@RequestParam(value = "queryFlatformId", required = false) Integer queryFlatformId,
			@RequestParam(value = "queryCategoryLevel1", required = false) Integer queryCategoryLevel1,
			@RequestParam(value = "queryCategoryLevel2", required = false) Integer queryCategoryLevel2,
			@RequestParam(value = "queryCategoryLevel3", required = false) Integer queryCategoryLevel3,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
		
		if(""==querySoftwareName){
			querySoftwareName=null;
		}
		// 查询一级菜单
		List<app_category> categoryLevel1List = categoryService.selectCategory1();
		// 查询app状态
		List<data_dictionary> statusList = dictionaryService.selectAppstatus();
		// 查询app所属平台
		List<data_dictionary> flatFormList = dictionaryService.selectApp_flatform();
		// 分页查询app信息
		//查找总数
		int count=appInfoService.count(querySoftwareName, queryStatus, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3);
		int currentPage=1;
		if(pageIndex!=null){
			currentPage=pageIndex;
		}
		Pager pager=new Pager(count, 5, currentPage);
		if(currentPage<1){
			currentPage=1;
		}
		if(currentPage>pager.getPageCount()){
			currentPage=pager.getCurrentPage();
		}
        List<app_info> appInfoList=appInfoService.selectAppInfo(querySoftwareName, queryStatus, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, (currentPage-1)*pager.getRowPerPage(), pager.getRowPerPage());
        //保存数据
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryLevel1List", categoryLevel1List); // 保存app一级菜单
		mav.addObject("statusList", statusList); // 保存app状态
		mav.addObject("flatFormList", flatFormList); // 保存app所属平台
		mav.addObject("pages", pager);  //分页数据
		mav.addObject("appInfoList", appInfoList); //显示数据
		mav.setViewName("/developer/appinfolist");
		return mav;
	}
}

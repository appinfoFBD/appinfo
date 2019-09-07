package cn.appsys.controller.developer;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import cn.appsys.pojo.app_category;
import cn.appsys.pojo.app_info;
import cn.appsys.pojo.app_version;
import cn.appsys.pojo.data_dictionary;
import cn.appsys.pojo.dev_user;
import cn.appsys.tools.Pager;
import cn.appsys.service.developer.*;

@Controller
@RequestMapping("/devApp")
public class appController {
	@Resource(name = "categoryService")
	// app菜单分类
	private categoryService categoryService;
	// app状态
	@Resource(name = "dictionaryService")
	private dictionaryService dictionaryService;
	// app信息
	@Resource(name = "appInfoService")
	private appInfoService appInfoService;
	@Resource(name = "versionService")
	private versionService versionService;

	// app查询列表
	@RequestMapping("/flatform")
	public ModelAndView appList(@RequestParam(value = "querySoftwareName", required = false) String querySoftwareName,
			@RequestParam(value = "queryStatus", required = false) Integer queryStatus,
			@RequestParam(value = "queryFlatformId", required = false) Integer queryFlatformId,
			@RequestParam(value = "queryCategoryLevel1", required = false) Integer queryCategoryLevel1,
			@RequestParam(value = "queryCategoryLevel2", required = false) Integer queryCategoryLevel2,
			@RequestParam(value = "queryCategoryLevel3", required = false) Integer queryCategoryLevel3,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex) {

		if ("" == querySoftwareName) {
			querySoftwareName = null;
		}
		// 查询一级菜单
		List<app_category> categoryLevel1List = categoryService.selectCategory1();
		// 查询app状态
		List<data_dictionary> statusList = dictionaryService.selectAppstatus();
		// 查询app所属平台
		List<data_dictionary> flatFormList = dictionaryService.selectApp_flatform();
		// 分页查询app信息
		// 查找总数
		int count = appInfoService.count(querySoftwareName, queryStatus, queryFlatformId, queryCategoryLevel1,
				queryCategoryLevel2, queryCategoryLevel3);
		int currentPage = 1;
		if (pageIndex != null) {
			currentPage = pageIndex;
		}
		Pager pager = new Pager(count, 5, currentPage);
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (currentPage > pager.getPageCount()) {
			currentPage = pager.getCurrentPage();
		}
		List<app_info> appInfoList = appInfoService.selectAppInfo(querySoftwareName, queryStatus, queryFlatformId,
				queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3,
				(currentPage - 1) * pager.getRowPerPage(), pager.getRowPerPage());
		// 保存数据
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryLevel1List", categoryLevel1List); // 保存app一级菜单
		mav.addObject("statusList", statusList); // 保存app状态
		mav.addObject("flatFormList", flatFormList); // 保存app所属平台
		mav.addObject("pages", pager); // 分页数据
		mav.addObject("appInfoList", appInfoList); // 显示数据
		mav.setViewName("/developer/appinfolist");
		return mav;
	}

	@RequestMapping(value = "/categorylevellist.json")
	@ResponseBody
	public Object findCategory(@RequestParam(value = "pid") Integer pid) {
		List<app_category> categoryList = categoryService.selectCategory(pid);
		return categoryList;
	}

	// 跳转到新增列表
	@RequestMapping("/appinfoadd")
	public String appinfoad(@ModelAttribute app_info app) {
		return "/developer/appinfoadd";
	}

	// 获取所属平台
	@RequestMapping("/datadictionarylist.json")
	@ResponseBody
	public Object dictionaryList() {
		List<data_dictionary> dictionaryList = dictionaryService.selectApp_flatform();
		return dictionaryList;
	}

	// 获取一级菜单
	// 获取所属平台
	@RequestMapping("/categorylevel.json")
	@ResponseBody
	public Object categorylevellist() {
		List<app_category> categoryList = categoryService.selectCategory1();
		return categoryList;
	}

	// 添加信息和实现文件上传
	@RequestMapping("/appinfoaddsave")
	public String appinfoaddsave(app_info app, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "a_logoPicPath", required = false) MultipartFile mult) {
		String logPicPath = ""; // 保存到本地路径
		String logLogPath = ""; // 服务器的路径
		if (!mult.isEmpty()) {
			// 设置服务器路径
			String path = request.getSession().getServletContext()
					.getRealPath("statics" + File.separator + "uploadfiles");
			// 源文件名
			String oldFileName = mult.getOriginalFilename();
			// 获取后缀
			String suffix = FilenameUtils.getExtension(oldFileName);
			// 设置文件大小
			int fileSize = 5000000;
			// 上传文件不得超过500kb
			if (mult.getSize() > fileSize) {
				request.setAttribute("uploadFileError", "* 上传文件大小不得超过500kb");
				return "/developer/appinfoadd";
			} else if (suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("jpeg")
					|| suffix.equalsIgnoreCase("png")) { // 文件格式必须是
															// jpg,jpeg,png格式
				// 新的图片名称
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + oldFileName;
				File file = new File(path, fileName);
				if (!file.exists()) {
					file.mkdirs();
				}
				// 保存到服务器
				try {
					mult.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				logPicPath = path.substring(path.lastIndexOf("/") + 70) + File.separator + fileName;
				logLogPath = path + File.separator + fileName;
			} else {
				request.setAttribute("uploadFileError", "* 文件格式不正确");
				return "/developer/appinfoadd";
			}

		}
		// 保存到数据库
		app.setCreatedBy(((dev_user) session.getAttribute("devUser")).getId());
		app.setCreationDate(new Date());
		app.setLogoPicPath(logPicPath);
		app.setLogoLocPath(logLogPath);
		if (appInfoService.appAdd(app)) {
			return "redirect:/devApp/flatform";
		}
		return "/developer/appinfoadd";

	}

	// 验证apk是否存在
	@RequestMapping("/apkexist.json")
	@ResponseBody
	public Object apkexist(@RequestParam("APKName") String APKName) {
		String status = "";
		app_info app = appInfoService.findApp(APKName);
		if (APKName == null || APKName == "") {
			status = "empty";
		} else if (app != null) {
			status = "exist";
		} else {
			status = "noexist";
		}
		return "{\"APKName\":\"" + status + "\"}";
	}

	// 跳转到修改页面
	@RequestMapping("/appinfomodify")
	public ModelAndView appinfomodify(@RequestParam("id") Integer id) {
		// 查询修改的信息添加到model中
		app_info app = appInfoService.findAppInfo(id);
		ModelAndView mav = new ModelAndView();
		if (app != null) {
			mav.addObject("appInfo", app);
			mav.setViewName("/developer/appinfomodify");
		} else {
			mav.setViewName("/developer/appinfolist");
		}
		return mav;
	}

	// 修改信息
	@RequestMapping("/appinfomodifysave")
	public String appinfomodifysave(app_info app, HttpSession session,
			@RequestParam(value = "status", required = false) Integer status) {
		app.setModifyBy(((dev_user) session.getAttribute("devUser")).getId());
		app.setModifyDate(new Date());
		if (status != null) {
			app.setStatus(status);
		}
		// 更新
		if (appInfoService.appinfomodify(app)) {
			return "redirect:/devApp/flatform";
		} else {
			return "/developer/appinfomodify";
		}

	}

	// 跳转到新增版本页面
	@RequestMapping("/appversionadd")
	public ModelAndView appversionadd(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		// 查询app版本信息
		app_info app = appInfoService.selectAppVersion(id);
		mav.addObject("appVersionList", app.getVersionList()); // 保存id发布过的版本
		mav.addObject("appVersion", app);
		mav.setViewName("/developer/appversionadd");
		return mav;
	}

	// 新增版本
	@RequestMapping("/addversionsave")
	public String addversionsave(@RequestParam("appId") Integer appId,
			@RequestParam("a_downloadLink") MultipartFile part, HttpServletRequest request, app_version version,
			HttpSession session) {
		String downloadLink = ""; // 下载链接
		String apkLocPath = ""; // 服务器路径
		String apkFileName = ""; // 上传apk的名称
		String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "apkFiles");
		if (!part.isEmpty()) {
			// 获取文件名
			String odlFileName = part.getOriginalFilename();
			// 获取源文件名后缀
			String suffix = FilenameUtils.getExtension(odlFileName);
			// 定义上传文件的大小
			int fileSize = 51200000;
			if (part.getSize() > fileSize) {
				request.setAttribute("fileUploadError", "* 文件大小限制500MB");
				return "/developer/appversionadd";
			} else if (suffix.equalsIgnoreCase("apk")) {
				// 查询app的APK名称
				app_info appInfo = appInfoService.findAPKName(appId);
				// 文件名
				String fileName = appInfo.getAPKName() + "-" + version.getVersionNo() + ".apk";
				File file = new File(path, fileName);
				if (!file.exists()) {
					file.mkdirs();
				}
				// 保存
				try {
					part.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("fileUploadError", "* 上传失败");
					return "/developer/appversionadd";

				}
				// 服务器的路径
				apkLocPath = path + File.separator + fileName;
				// 上传的名称
				apkFileName = fileName;
				// 下载的路径
				downloadLink = path.substring(path.lastIndexOf("/") + 70) + File.separator + fileName;
			} else {
				request.setAttribute("fileUploadError", "* 上传文件格式不正确");
				return "/developer/appversionadd";
			}
		}
		// 添加
		version.setCreatedBy(((dev_user) session.getAttribute("devUser")).getId());
		version.setCreationDate(new Date());
		version.setDownloadLink(downloadLink);
		version.setApkFileName(apkFileName);
		version.setApkLocPath(apkLocPath);
		if (versionService.insertVersion(version)) {
			return "redirect:/devApp/flatform";
		}
		return "/developer/appversionadd";
	}

	// 跳转到修改版本页面并查询版本信息
	@RequestMapping("/appversionmodify")
	public String appversionmodify(@RequestParam("vid") Integer versionid,
			@RequestParam("aid") Integer appinfoid, Model model) {
		// 查询所有的版本信息
		app_info app = appInfoService.selectAppVersion(appinfoid);
		model.addAttribute("appVersionList", app.getVersionList()); // 保存id发布过的版本
		// 查询app版本信息
		app_version version = versionService.selectVersion(versionid, appinfoid);
		model.addAttribute("appVersion", version);
		return "/developer/appversionmodify";

	}
	//修改版本
	/**
	 * @param version
	 * @param session
	 * @return
	 */
	@RequestMapping("/appversionmodifysave")
	public String appversionmodifysave(app_version version,HttpSession session,HttpServletRequest request){
		version.setModifyBy(((dev_user)session.getAttribute("devUser")).getId());
		version.setModifyDate(new Date());
		if(versionService.updateVersion(version)){
			return "redirect:/devApp/flatform";
		}else{
			request.setAttribute("fileUploadError","* 修改失败");
			return "/developer/appversionmodify";
		}
		
	}
	//查看app基础信息
	@RequestMapping("/appview/{id}")
	public String appview(@PathVariable Integer id,Model model){
		//查询app的基础信息
		app_info appInfo=appInfoService.findAppInfo(id);
	    if(appInfo.getVersionId()!=null){
	    	//查询app的历史版本
		    app_info appVersion=appInfoService.selectAppVersion(id);
	    	model.addAttribute("appVersionList",appVersion.getVersionList());
	    }
	    
	    model.addAttribute("appInfo",appInfo);
	    return "/developer/appinfoview";
	}
	//返回查询页面
	@RequestMapping("/list")
	public String list(){
		return "redirect:/devApp/flatform";
	}
}

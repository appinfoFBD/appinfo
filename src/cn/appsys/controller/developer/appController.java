package cn.appsys.controller.developer;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	// app锟剿碉拷锟斤拷锟斤拷
	private categoryService categoryService;
	// app状态
	@Resource(name = "dictionaryService")
	private dictionaryService dictionaryService;
	// app锟斤拷息
	@Resource(name = "appInfoService")
	private appInfoService appInfoService;
	@Resource(name = "versionService")
	private versionService versionService;

	// app锟斤拷询锟叫憋拷
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
		// 锟斤拷询一锟斤拷锟剿碉拷
		List<app_category> categoryLevel1List = categoryService.selectCategory1();
		// 锟斤拷询app状态
		List<data_dictionary> statusList = dictionaryService.selectAppstatus();
		// 锟斤拷询app锟斤拷锟斤拷平台
		List<data_dictionary> flatFormList = dictionaryService.selectApp_flatform();
		// 锟斤拷页锟斤拷询app锟斤拷息
		// 锟斤拷锟斤拷锟斤拷锟斤拷
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
		// 锟斤拷锟斤拷锟斤拷锟斤拷
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryLevel1List", categoryLevel1List); // 锟斤拷锟斤拷app一锟斤拷锟剿碉拷
		mav.addObject("statusList", statusList); // 锟斤拷锟斤拷app状态
		mav.addObject("flatFormList", flatFormList); // 锟斤拷锟斤拷app锟斤拷锟斤拷平台
		mav.addObject("pages", pager); // 锟斤拷页锟斤拷锟斤拷
		mav.addObject("appInfoList", appInfoList); // 锟斤拷示锟斤拷锟斤拷
		mav.setViewName("/developer/appinfolist");
		return mav;
	}

	@RequestMapping(value = "/categorylevellist.json")
	@ResponseBody
	public Object findCategory(@RequestParam(value = "pid") Integer pid) {
		List<app_category> categoryList = categoryService.selectCategory(pid);
		return categoryList;
	}

	// 锟斤拷转锟斤拷锟斤拷锟斤拷锟叫憋拷
	@RequestMapping("/appinfoadd")
	public String appinfoad(@ModelAttribute app_info app) {
		return "/developer/appinfoadd";
	}

	// 锟斤拷取锟斤拷锟斤拷平台
	@RequestMapping("/datadictionarylist.json")
	@ResponseBody
	public Object dictionaryList() {
		List<data_dictionary> dictionaryList = dictionaryService.selectApp_flatform();
		return dictionaryList;
	}

	// 锟斤拷取一锟斤拷锟剿碉拷
	// 锟斤拷取锟斤拷锟斤拷平台
	@RequestMapping("/categorylevel.json")
	@ResponseBody
	public Object categorylevellist() {
		List<app_category> categoryList = categoryService.selectCategory1();
		return categoryList;
	}

	// 锟斤拷锟斤拷锟较拷锟绞碉拷锟斤拷募锟斤拷洗锟�
	@RequestMapping("/appinfoaddsave")
	public String appinfoaddsave(app_info app, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "a_logoPicPath", required = false) MultipartFile mult) {
		String logPicPath = ""; // 锟斤拷锟芥到锟斤拷锟斤拷路锟斤拷
		String logLogPath = ""; // 锟斤拷锟斤拷锟斤拷锟斤拷路锟斤拷
		if (!mult.isEmpty()) {
			// 锟斤拷锟矫凤拷锟斤拷锟斤拷路锟斤拷
			String path = request.getSession().getServletContext()
					.getRealPath("statics" + File.separator + "uploadfiles");
			// 源锟侥硷拷锟斤拷
			String oldFileName = mult.getOriginalFilename();
			// 锟斤拷取锟斤拷缀
			String suffix = FilenameUtils.getExtension(oldFileName);
			// 锟斤拷锟斤拷锟侥硷拷锟斤拷小
			int fileSize = 5000000;
			// 锟较达拷锟侥硷拷锟斤拷锟矫筹拷锟斤拷500kb
			if (mult.getSize() > fileSize) {
				request.setAttribute("uploadFileError", "* 锟较达拷锟侥硷拷锟斤拷小锟斤拷锟矫筹拷锟斤拷500kb");
				return "/developer/appinfoadd";
			} else if (suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("jpeg")
					|| suffix.equalsIgnoreCase("png")) { // 锟侥硷拷锟斤拷式锟斤拷锟斤拷锟斤拷
															// jpg,jpeg,png锟斤拷式
				// 锟铰碉拷图片锟斤拷锟斤拷
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + oldFileName;
				File file = new File(path, fileName);
				if (!file.exists()) {
					file.mkdirs();
				}
				// 锟斤拷锟芥到锟斤拷锟斤拷锟斤拷
				try {
					mult.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				logPicPath = path.substring(path.lastIndexOf("/") + 70) + File.separator + fileName;
				logLogPath = path + File.separator + fileName;
			} else {
				request.setAttribute("uploadFileError", "* 锟侥硷拷锟斤拷式锟斤拷锟斤拷确");
				return "/developer/appinfoadd";
			}

		}
		// 锟斤拷锟芥到锟斤拷锟捷匡拷
		app.setCreatedBy(((dev_user) session.getAttribute("devUser")).getId());
		app.setCreationDate(new Date());
		app.setLogoPicPath(logPicPath);
		app.setLogoLocPath(logLogPath);
		if (appInfoService.appAdd(app)) {
			return "redirect:/devApp/flatform";
		}
		return "/developer/appinfoadd";

	}

	// 锟斤拷证apk锟角凤拷锟斤拷锟�
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

	// 锟斤拷转锟斤拷锟睫革拷页锟斤拷
	@RequestMapping("/appinfomodify")
	public ModelAndView appinfomodify(@RequestParam("id") Integer id) {
		// 锟斤拷询锟睫改碉拷锟斤拷息锟斤拷拥锟絤odel锟斤拷
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

	// 锟睫革拷锟斤拷息
	@RequestMapping("/appinfomodifysave")
	public String appinfomodifysave(app_info app, HttpSession session,
			@RequestParam(value = "status", required = false) Integer status) {
		app.setModifyBy(((dev_user) session.getAttribute("devUser")).getId());
		app.setModifyDate(new Date());
		if (status != null) {
			app.setStatus(status);
		}
		// 锟斤拷锟斤拷
		if (appInfoService.appinfomodify(app)) {
			return "redirect:/devApp/flatform";
		} else {
			return "/developer/appinfomodify";
		}

	}

	// 锟斤拷转锟斤拷锟斤拷锟斤拷锟芥本页锟斤拷
	@RequestMapping("/appversionadd")
	public ModelAndView appversionadd(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		app_info app = appInfoService.findAppInfo(id);
		if (app.getVersionId() != null) {
			// 锟斤拷锟絘pp锟叫凤拷锟斤拷锟斤拷锟芥本锟酵诧拷询锟斤拷锟斤拷锟叫的版本
			List<app_version> versionList = versionService.versionList(id);
			mav.addObject("appVersionList", versionList);
		}
		mav.addObject("appVersion", app);
		mav.setViewName("/developer/appversionadd");
		return mav;
	}

	// 锟斤拷锟斤拷锟芥本
	@RequestMapping("/addversionsave")
	public String addversionsave(@RequestParam("appId") Integer appId,
			@RequestParam("a_downloadLink") MultipartFile part, HttpServletRequest request, app_version version,
			HttpSession session) {
		String downloadLink = ""; // 锟斤拷锟斤拷锟斤拷锟斤拷
		String apkLocPath = ""; // 锟斤拷锟斤拷锟斤拷路锟斤拷
		String apkFileName = ""; // 锟较达拷apk锟斤拷锟斤拷锟斤拷
		String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "apkFiles");
		if (!part.isEmpty()) {
			// 锟斤拷取锟侥硷拷锟斤拷
			String odlFileName = part.getOriginalFilename();
			// 锟斤拷取源锟侥硷拷锟斤拷锟斤拷缀
			String suffix = FilenameUtils.getExtension(odlFileName);
			// 锟斤拷锟斤拷锟较达拷锟侥硷拷锟侥达拷小
			int fileSize = 51200000;
			if (part.getSize() > fileSize) {
				request.setAttribute("fileUploadError", "* 锟侥硷拷锟斤拷小锟斤拷锟斤拷500MB");
				return "/developer/appversionadd";
			} else if (suffix.equalsIgnoreCase("apk")) {
				// 锟斤拷询app锟斤拷APK锟斤拷锟斤拷
				System.out.println(appId);
				app_info appInfo = appInfoService.findAPKName(appId);
				// 锟侥硷拷锟斤拷
				String fileName = appInfo.getAPKName() + "-" + version.getVersionNo() + ".apk";
				File file = new File(path, fileName);
				if (!file.exists()) {
					file.mkdirs();
				}
				// 锟斤拷锟斤拷
				try {
					part.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("fileUploadError", "* 锟较达拷失锟斤拷");
					return "/developer/appversionadd";

				}
				// 锟斤拷锟斤拷锟斤拷锟斤拷路锟斤拷
				apkLocPath = path + File.separator + fileName;
				// 锟较达拷锟斤拷锟斤拷锟斤拷
				apkFileName = fileName;
				// 锟斤拷锟截碉拷路锟斤拷
				downloadLink = path.substring(path.lastIndexOf("/") + 70) + File.separator + fileName;
			} else {
				request.setAttribute("fileUploadError", "* 锟较达拷锟侥硷拷锟斤拷式锟斤拷锟斤拷确");
				return "/developer/appversionadd";
			}
		}
		// 锟斤拷锟�
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

	// 锟斤拷转锟斤拷锟睫改版本页锟芥并锟斤拷询锟芥本锟斤拷息
	@RequestMapping("/appversionmodify")
	public String appversionmodify(@RequestParam("vid") Integer versionid, @RequestParam("aid") Integer appinfoid,
			Model model) {
		// 锟斤拷询锟斤拷锟叫的版本锟斤拷息
		app_info app = appInfoService.selectAppVersion(appinfoid);
		model.addAttribute("appVersionList", app.getVersionList()); // 锟斤拷锟斤拷id锟斤拷锟斤拷锟斤拷锟侥版本
		// 锟斤拷询app锟芥本锟斤拷息
		app_version version = versionService.selectVersion(versionid, appinfoid);
		model.addAttribute("appVersion", version);
		return "/developer/appversionmodify";

	}

	// 锟睫改版本
	/**
	 * @param version
	 * @param session
	 * @return
	 */
	@RequestMapping("/appversionmodifysave")
	public String appversionmodifysave(app_version version, HttpSession session, HttpServletRequest request) {
		version.setModifyBy(((dev_user) session.getAttribute("devUser")).getId());
		version.setModifyDate(new Date());
		if (versionService.updateVersion(version)) {
			return "redirect:/devApp/flatform";
		} else {
			request.setAttribute("fileUploadError", "* 锟睫革拷失锟斤拷");
			return "/developer/appversionmodify";
		}

	}

	// 锟介看app锟斤拷锟斤拷锟斤拷息
	@RequestMapping("/appview/{id}")
	public String appview(@PathVariable Integer id, Model model) {
		// 锟斤拷询app锟侥伙拷锟斤拷锟斤拷息
		app_info appInfo = appInfoService.findAppInfo(id);
		if (appInfo.getVersionId() != null) {
			// 锟斤拷询app锟斤拷锟斤拷史锟芥本
			List<app_version> appVersionList = versionService.versionList(id);
			model.addAttribute("appVersionList", appVersionList);
		}
		model.addAttribute("appInfo", appInfo);
		return "/developer/appinfoview";
	}

	// 锟斤拷锟截诧拷询页锟斤拷
	@RequestMapping("/list")
	public String list() {
		return "redirect:/devApp/flatform";
	}
	//删除app信息
	@RequestMapping("/delapp.json")
	@ResponseBody
	public Object delectAppInfo(@RequestParam("id")Integer id){
		HashMap<String,String> delResult=new HashMap<String,String>();
		String status="";
		//查询要删除的app信息
		app_info appInfo=appInfoService.findAPKName(id);
		if(appInfo==null){
			status="notexist";
		}else{
			//删除操作
			if(appInfoService.delectApp(appInfo, id)){
				status="true";
			}else{
				status="false";
			}
		}
		delResult.put("delResult", status);
		return delResult;
	}
}

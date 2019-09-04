package cn.appsys.controller.developer;

import java.io.File;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import cn.appsys.pojo.app_category;
import cn.appsys.pojo.app_info;
import cn.appsys.pojo.data_dictionary;
import cn.appsys.pojo.dev_user;
import cn.appsys.tools.Pager;
import cn.appsys.service.developer.*;

@Controller
@RequestMapping("/devApp")
public class appController {
	@Resource(name = "categoryService")
	// app�˵�����
	private categoryService categoryService;
	// app״̬
	@Resource(name = "dictionaryService")
	private dictionaryService dictionaryService;
	// app��Ϣ
	@Resource(name = "appInfoService")
	private appInfoService appInfoService;

	// app��ѯ�б�
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
		// ��ѯһ���˵�
		List<app_category> categoryLevel1List = categoryService.selectCategory1();
		// ��ѯapp״̬
		List<data_dictionary> statusList = dictionaryService.selectAppstatus();
		// ��ѯapp����ƽ̨
		List<data_dictionary> flatFormList = dictionaryService.selectApp_flatform();
		// ��ҳ��ѯapp��Ϣ
		// ��������
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
		// ��������
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryLevel1List", categoryLevel1List); // ����appһ���˵�
		mav.addObject("statusList", statusList); // ����app״̬
		mav.addObject("flatFormList", flatFormList); // ����app����ƽ̨
		mav.addObject("pages", pager); // ��ҳ����
		mav.addObject("appInfoList", appInfoList); // ��ʾ����
		mav.setViewName("/developer/appinfolist");
		return mav;
	}

	@RequestMapping(value = "/categorylevellist.json")
	@ResponseBody
	public Object findCategory(@RequestParam(value = "pid") Integer pid) {
		List<app_category> categoryList = categoryService.selectCategory(pid);
		return categoryList;
	}

	// ��ת�������б�
	@RequestMapping("/appinfoadd")
	public String appinfoad(@ModelAttribute app_info app) {
		return "/developer/appinfoadd";
	}

	// ��ȡ����ƽ̨
	@RequestMapping("/datadictionarylist.json")
	@ResponseBody
	public Object dictionaryList() {
		List<data_dictionary> dictionaryList = dictionaryService.selectApp_flatform();
		return dictionaryList;
	}

	// ��ȡһ���˵�
	// ��ȡ����ƽ̨
	@RequestMapping("/categorylevel.json")
	@ResponseBody
	public Object categorylevellist() {
		List<app_category> categoryList = categoryService.selectCategory1();
		return categoryList;
	}

	// �����Ϣ��ʵ���ļ��ϴ�
	@RequestMapping("/appinfoaddsave")
	public String appinfoaddsave(app_info app, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "a_logoPicPath", required = false) MultipartFile mult) {
		String logPicPath = ""; // ���浽����·��
		String logLogPath="";   //��������·��
		if (!mult.isEmpty()) {
			// ���÷�����·��
			String path = request.getSession().getServletContext()
					.getRealPath("statics" + File.separator + "uploadfiles");
			// Դ�ļ���
			String oldFileName = mult.getOriginalFilename();
			// ��ȡ��׺
			String suffix = FilenameUtils.getExtension(oldFileName);
			// �����ļ���С
			int fileSize = 5000000;
			// �ϴ��ļ����ó���500kb
			if (mult.getSize() > fileSize) {
				request.setAttribute("uploadFileError", "* �ϴ��ļ���С���ó���500kb");
				return "/developer/appinfoadd";
			} else if (suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("jpeg")
					|| suffix.equalsIgnoreCase("png")) { // �ļ���ʽ������
															// jpg,jpeg,png��ʽ
				// �µ�ͼƬ����
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + oldFileName;
				File file = new File(path, fileName);
				if (!file.exists()) {
					file.mkdirs();
				}
				// ���浽������
				try {
					mult.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				logPicPath = path.substring(path.lastIndexOf("/")+70)+File.separator+fileName;
			    logLogPath=path+File.separator+fileName;
			} else {
				request.setAttribute("uploadFileError", "* �ļ���ʽ����ȷ");
				return "/developer/appinfoadd";
			}

		}
		// ���浽���ݿ�
		app.setCreatedBy(((dev_user) session.getAttribute("devUser")).getId());
		app.setCreationDate(new Date());
		app.setLogoPicPath(logPicPath);
		app.setLogoLocPath(logLogPath);
		if (appInfoService.appAdd(app)) {
			return "redirect:/devApp/flatform";
		}
		return "/developer/appinfoadd";

	}
	//��֤apk�Ƿ����
	@RequestMapping("/apkexist.json")
	@ResponseBody
	public Object apkexist(@RequestParam("APKName")String APKName){
		String status="";
		app_info app=appInfoService.findApp(APKName);
		if(APKName==null || APKName==""){
			status="empty";
		}else if(app!=null){
			 status="exist";
		}else{
			status="noexist";
		}
		return"{\"APKName\":\""+status+"\"}";
	}
}

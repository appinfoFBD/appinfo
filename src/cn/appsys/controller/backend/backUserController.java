package cn.appsys.controller.backend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.backend_user;
import cn.appsys.service.backend.backUserService;

@Controller
@RequestMapping("/backUser")
public class backUserController {
	@Autowired
	private backUserService backuserService;
	
     //璺宠浆鍒板悗鍙扮櫥褰曢〉闈�
	@RequestMapping("/login")
	public String login(){
		return "backendlogin";
	}
	
	//鐧诲綍鎿嶄綔
	@RequestMapping("/dologin")
	public String dologin(@RequestParam("userCode")String userCode,@RequestParam("userPassword")String userPassword,
			              HttpSession session){
		backend_user backUser=backuserService.doLoing(userCode);
		if(backUser==null){
			throw new RuntimeException("用户名错误");
		}else{
			if(!backUser.getUserPassword().equals(userPassword)){
				throw new RuntimeException("密码错误");
			}
		}
		session.setAttribute("userSession", backUser);
		return "/backend/main";
		
	}
	
	//寮傚父澶勭悊
	@ExceptionHandler(RuntimeException.class)
	public String exception(RuntimeException e,HttpServletRequest request){
		request.setAttribute("error", e.getMessage());
		return"backendlogin";
	}
}

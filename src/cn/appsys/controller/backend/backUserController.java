package cn.appsys.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backUser")
public class backUserController {
     //跳转到后台登录页面
	@RequestMapping("/login")
	public String login(){
		return "backendlogin";
	}
}

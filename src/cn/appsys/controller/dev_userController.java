package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.dev_user;
import cn.appsys.service.dev_userService;
@Controller
@RequestMapping("/devUser")
public class dev_userController {
	@Resource(name="dev_userService")
	private dev_userService dev_userService;
     //��ת����¼ҳ��
	@RequestMapping(value="/login")
	 public String login(){
		 return"devlogin";
	 }
	@RequestMapping("/doLogin")
	//��¼
	public String doLogin(@RequestParam("devCode")String devCode,@RequestParam("devPassword") String devPassword,HttpSession session){
	     dev_user user=dev_userService.findLogin(devCode);
	     if(user==null){
	    	 throw new RuntimeException("�û�������");
	     }else{
	    	 if(!user.getDevPassword().equals(devPassword)){
	    		 throw new RuntimeException("�������");
	    	 }
	    	 //������û�������ȷ�ͱ����û����Ự��
	    	 session.setAttribute("devUser", user);
	     }
	     return"/developer/main";
	}
	//ע������
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		dev_user user=(dev_user)session.getAttribute("devUser");
		if(user!=null){
			session.removeAttribute("devUser");
		}
		return "devlogin";
	}
	//�ֲ��쳣����
	@ExceptionHandler(value={RuntimeException.class})
	public String error(RuntimeException e,HttpServletRequest request){
		request.setAttribute("error", e.getMessage());
		return"devlogin";
	}
}

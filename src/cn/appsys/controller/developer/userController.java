package cn.appsys.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.dev_user;
import cn.appsys.service.developer.*;
@Controller
@RequestMapping("/devUser")
public class userController {
	@Resource(name="userService")
	private userService userService;
     //��ת����¼ҳ��
	@RequestMapping(value="/login")
	 public String login(){
		 return"devlogin";
	 }
	@RequestMapping("/doLogin")
	//��¼
	public String doLogin(@RequestParam("devCode")String devCode,@RequestParam("devPassword") String devPassword,HttpSession session){
	     dev_user user=userService.findLogin(devCode);
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

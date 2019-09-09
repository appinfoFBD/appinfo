package cn.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.appsys.pojo.dev_user;

public class SysInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		HttpSession session=arg0.getSession();
		dev_user devUser=(dev_user)session.getAttribute("devUser");
		if(devUser==null){
			
			arg0.setAttribute("error", "ÇëÏÈµÇÂ¼");
			arg0.getRequestDispatcher("/WEB-INF/jsp/devlogin.jsp").forward(arg0, arg1);
			return false;
		}
		return true;
	}
   
}

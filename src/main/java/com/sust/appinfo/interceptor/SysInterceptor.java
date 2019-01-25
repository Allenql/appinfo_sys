package com.sust.appinfo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sust.appinfo.pojo.BackendUser;
import com.sust.appinfo.pojo.DevUser;
import com.sust.appinfo.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SysInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = Logger.getLogger(SysInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		logger.debug("SysInterceptor preHandle ==========================");
		HttpSession session = request.getSession();
		
		BackendUser backendUser = (BackendUser)session.getAttribute(Constants.USER_SESSION);
		DevUser devUser = (DevUser)session.getAttribute(Constants.DEV_USER_SESSION);

		if(null != devUser){ //dev SUCCESS
			return true;
		}else if(null != backendUser){ //backend SUCCESS
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/403.jsp");
			return false;
		}
		
	}
}

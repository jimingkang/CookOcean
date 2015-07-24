package com.topshare.airshuttle.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.common.util.ConstantsUtil;
import com.topshare.airshuttle.common.util.DBEncrypt;
import com.topshare.airshuttle.dao.userManager.UserDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleUser;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class UserLoginFilter implements Filter {

	private Logger logger = Logger.getLogger(this.getClass());
	
	private static List<String> excludesList = new ArrayList<String>();
	
	static{
		
		excludesList.add("jpg");
		excludesList.add("gif");
		excludesList.add("png");
		excludesList.add("js");
		excludesList.add("css");
	}
	
	@Autowired
	private UserDAO userDAO;
	
    /**
     * Default constructor. 
     */
    public UserLoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpServletResponse hresponse = (HttpServletResponse)response;
		HttpSession session = hrequest.getSession();
    	
    	String uri = hrequest.getRequestURI();
    	logger.debug("uri:"+uri);
    	if (isExcluded(uri)) {
            logger.debug("Excluded request: "+ uri);
            chain.doFilter(request, response);
            return;
        } else {
        	logger.debug("Accepted and started to process request: "+ uri);
        }
    	
    	
    	//logger.info("uri:"+uri);
//		if(uri.contains("/user/login")){
//			
//			String username = hrequest.getParameter("username");
//			String password = hrequest.getParameter("password");
//			
//			//TODO
//			TAirshuttleUser user = new TAirshuttleUser();
//			user.setUsername(username);
//			user.setPassword(password);
//			DBEncrypt dBEncrypt = new DBEncrypt();
//			user.setPassword(dBEncrypt.eCode(password));
//			user = userDAO.getUserByLogin(user);
//
//			
//			if(user == null){
//			
//				hresponse.sendRedirect(hrequest.getContextPath()+"/index.jsp");
//				return;
//			}
//			//System.out.println("jimmy test "+ user.getPassword());
//			session.setAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY, user);
//			hresponse.sendRedirect(hrequest.getContextPath()+"/views/index.jsp");
//			return;
//		}else if(uri.contains("/user/loginOut")){
//			try {
//				session.invalidate();
//				hresponse.sendRedirect(hrequest.getContextPath()+"/login.jsp");
//				return;
//			} catch (Exception e) {
//			}
//
//		}else{
//			//非登陆显示页面，请放到非view文件夹外
//			if(uri.contains("index.jsp")){
//				chain.doFilter(request, response);
//				return;
//			}else{
//				User user = (User)session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
//				//跳转到登录页面
//				if(user == null){
//					
//					hresponse.sendRedirect(hrequest.getContextPath()+"/index.jsp");
//					return;
//				}else{
//					//校验请求合法性
//					//TODO
//					chain.doFilter(request, response);
//					return;
//				}
//			}
//		}
		
	}

	
	private boolean isExcluded(String path) {
			
			for(String excludeStr : excludesList){
				
				if(path.endsWith(excludeStr)){
					
					return true;
				}
			}
		

	        return false;
	    }
	 
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}

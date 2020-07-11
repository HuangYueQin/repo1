package com.maternalBabyManage.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
/**
 * 
 * @author 
 * @data 2019/4/22
 * 未登录访问拦截
 *
 */
public class LoginInterceptor implements HandlerInterceptor{  //未登录拦截
	//登录地址
	private static final String loginUrl = "/login";
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object obj) throws Exception{
		HttpSession session = request.getSession(false);
		if(session == null || !request.isRequestedSessionIdValid()) {   //session创建失败直接重定向
			response.sendRedirect(request.getContextPath()+loginUrl);
			return false;
		}
		Object object = session.getAttribute("LoginName");    //获取登录用户名
		if(object == null) {                                  //登录用户名不存在，提示后重定向
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<script>alert('请先登录再执行其他操作！');document.location.href='"+request.getContextPath()+loginUrl+"';</script>");
			return false;
		}
		return true;
	}
}

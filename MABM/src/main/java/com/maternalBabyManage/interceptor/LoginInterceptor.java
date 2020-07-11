package com.maternalBabyManage.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
/**
 * 
 * @author 
 * @data 2019/4/22
 * δ��¼��������
 *
 */
public class LoginInterceptor implements HandlerInterceptor{  //δ��¼����
	//��¼��ַ
	private static final String loginUrl = "/login";
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object obj) throws Exception{
		HttpSession session = request.getSession(false);
		if(session == null || !request.isRequestedSessionIdValid()) {   //session����ʧ��ֱ���ض���
			response.sendRedirect(request.getContextPath()+loginUrl);
			return false;
		}
		Object object = session.getAttribute("LoginName");    //��ȡ��¼�û���
		if(object == null) {                                  //��¼�û��������ڣ���ʾ���ض���
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<script>alert('���ȵ�¼��ִ������������');document.location.href='"+request.getContextPath()+loginUrl+"';</script>");
			return false;
		}
		return true;
	}
}

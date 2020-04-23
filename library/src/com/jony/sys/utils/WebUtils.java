package com.jony.sys.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * web�Ĺ�����
 * @author LJH
 *
 */
public class WebUtils {
	
	public static ServletRequestAttributes getServletRequestAttributes() {
		return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	}
	
	/**
	 * �õ���ǰ�̵߳��������
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return getServletRequestAttributes().getRequest();
	}
	
	/**
	 * �õ���ǰ�̵߳���Ӧ����
	 */
	public static HttpServletResponse getHttpServletResponse() {
		return getServletRequestAttributes().getResponse();
	}
	
	/**
	 * �õ�session����
	 */
	public static HttpSession getHttpSession() {
		return getHttpServletRequest().getSession();
	}
	
	/**
	 * �õ�servletContext����
	 */
	public static ServletContext getServletContext() {
		return getHttpServletRequest().getServletContext();
	}
	
	
}

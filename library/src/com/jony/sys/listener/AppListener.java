package com.jony.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//ȡ��ServletContext
		ServletContext context=arg0.getServletContext();
		context.setAttribute("ctx", context.getContextPath());
		System.err.println("---------Servlet���������ɹ� ctx���ŵ�ServletContext������-------");
	}

}

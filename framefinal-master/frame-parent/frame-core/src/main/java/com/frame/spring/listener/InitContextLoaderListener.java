package com.frame.spring.listener;

import javax.servlet.ServletContextEvent;
import org.springframework.web.context.ContextLoaderListener;

public class InitContextLoaderListener extends ContextLoaderListener {

	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		System.out.println("contextInitialized :" +
				event.getServletContext().getServletContextName());
	}


	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		System.out.println("contextDestroyed");
	}
}

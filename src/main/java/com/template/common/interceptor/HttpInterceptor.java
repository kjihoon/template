package com.template.common.interceptor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class HttpInterceptor extends HandlerInterceptorAdapter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object handler) {
		if(logger.isDebugEnabled()){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
			
	        String CURRENT_TIME = sdf.format(cal.getTime());
			request.setAttribute("CURRENT_TIME", CURRENT_TIME);
			
			
			logger.debug("===========START:"+CURRENT_TIME+"\t"+request.getRequestURI());
			logger.debug("QUERY:\t"+request.getQueryString());
		}
		return true;
	}
	
	@Override
	public void postHandle( HttpServletRequest request,
							HttpServletResponse response,
							Object handler,
							ModelAndView modelAndView) {
		
		if(logger.isDebugEnabled()){
			if (handler instanceof HandlerMethod) {
				HandlerMethod handlerMethod = (HandlerMethod) handler;
				logger.debug("DESC:\t"+handlerMethod.getShortLogMessage());
			}
        }
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response, 
								Object handler, 
								Exception ex) {
		if(logger.isDebugEnabled()){
			logger.debug("===========END:"+request.getAttribute("CURRENT_TIME")+"\t");
		}
	}
}
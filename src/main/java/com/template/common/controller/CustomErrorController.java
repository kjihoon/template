package com.template.common.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request,Exception except) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	logger.error("404");
	        	logger.error(except.getMessage());
	            return "/error/error-404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	logger.error("500");
	        	logger.error(except.getMessage());
	            return "/error/error-500";
	        }
	    }
	    return "error/error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}

package com.template.common.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	@Qualifier(value = "httpInterceptor")
	private HandlerInterceptor httpinterceptor;

	
	@Autowired
	@Qualifier(value = "jsonInterceptor")
	private HandlerInterceptor jsoninterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(httpinterceptor)
				.addPathPatterns("/**").excludePathPatterns("/json/**");
		
		registry.addInterceptor(jsoninterceptor)
		.addPathPatterns("/json/**");
	
	}
	
}

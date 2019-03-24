package com.template.common.util;


import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtil {

	public static String toJsonString(Object obj) {
		String jsonString="";
		try {
			ObjectMapper om = new ObjectMapper();
			jsonString =om.writeValueAsString(obj);
		}catch(Exception e) {
			jsonString = "{errmsg:'"+e.getMessage()+"'}";
		}
		return jsonString;
	}
	
	
	
	
}

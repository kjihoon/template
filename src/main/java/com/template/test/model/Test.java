package com.template.test.model;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Alias("Test")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE)
public class Test {
	
	@Getter
	@Setter
	private String tmp;

	public String getTmp() {
		return tmp;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	
}

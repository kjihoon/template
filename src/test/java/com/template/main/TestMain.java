package com.template.main;

import org.junit.Test;

import com.template.common.util.SHAUtil;

public class TestMain {

	public static void main(String args []) {
		
		String str = "a";
		
		String sha = SHAUtil.getSHA256(str);
		
		System.out.println(sha);
	}
}

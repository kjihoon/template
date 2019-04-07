package com.template.main.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.common.util.JsonUtil;
import com.template.common.util.RSAUtil;

@RestController
public class SecurityController {

	@GetMapping("/rsa")
	public String rsa(HttpSession session) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		RSAUtil keyPair = new RSAUtil();
		
		session.setAttribute("__rsaPrivateKey__", keyPair.getPrivateKey());
		
		
		return JsonUtil.toJsonString(keyPair.getPublicKey());
	}
}

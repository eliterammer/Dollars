package com.trendanora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class TestController {
	
	
	@RequestMapping("/test")
	public String getPersonDetail(@RequestParam(value = "id",required = false,
	                                                    defaultValue = "0") Integer id) {
		
		return new String("sample -:- "+id);
	
	}

} 
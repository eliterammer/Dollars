package com.trendanora.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.trendanora.repository.CategoryDataRepository;

public class Testing {

	@Autowired
	CategoryDataRepository categoryDataRepository;
	
	public static void main(String args[]){
		BeanFactory.createBean(Testing.class);
		System.out.println("hi");
	}
}

package com.albraik.infra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/msg", method = RequestMethod.GET)
	public String getMsg(@RequestParam(required=false) String name)
	{
		if(name == null)
			return "Hello World!";
		else
			return "Hello " + name + "";
	}
	
	
}

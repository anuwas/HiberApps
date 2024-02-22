package com.ems.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	 @RequestMapping(value="/test")
	 public String test(ModelMap model) {
		 return "test";
	   }
}

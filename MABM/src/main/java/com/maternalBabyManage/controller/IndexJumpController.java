package com.maternalBabyManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexJumpController {
	
	@RequestMapping("/index")
	public String toIndex() {
		return "/index";
		
	}
    @RequestMapping("/success")
    public String success() {
    	return "/success";
    }
}

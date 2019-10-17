package com.example.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.biz.StudentBiz;
import com.example.demo.pojo.Student;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c")
public class ViewAction {

	@RequestMapping("index")
	public String goToIndex() {
		return "index";
	}
	
	@RequestMapping("login")
	public String goToLogin() {
		return "login";
	}
	
	
}

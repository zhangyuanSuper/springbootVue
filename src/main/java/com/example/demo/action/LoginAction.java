package com.example.demo.action;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.biz.StudentBiz;
import com.example.demo.pojo.Record;
import com.example.demo.pojo.Student;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/c/students")
public class LoginAction {

	@Autowired
	private StudentBiz sbiz;
	
	@PostMapping("loginIn")
	public String loginCheck(Model model,Student student,HttpSession session) {
		student=sbiz.queryByNameWithPwd(student);
		if(student!=null) {
			session.setAttribute("USERS", student);
			return "index";	
		}else {
			model.addAttribute("MSG", "用户名或密码错误");
			return "login";	
		}
	}
	
	@RequestMapping("getStudentList")
	public String showStudentList(Integer p, Integer s, Model model) {
		PageInfo<Student> pageInfo=sbiz.findStudentListByPage(p,s);
	    model.addAttribute("PAGE_INFO", pageInfo);
		return "student";
	}
	
	@RequestMapping("getRecordList")
	public String showRecordList(Integer p, Integer s, Model model,HttpSession session) {
		PageInfo<Record> pageInfo=sbiz.findRecordListByPage(p, s);
	    model.addAttribute("PAGE_INFO", pageInfo);
		return "info";
	}
	
	@RequestMapping("add")
	public String goToAdd(Model model) {
		List<Student> list=sbiz.queryAllStudent();
		model.addAttribute("INFO",list);
		return "add";
	}
	
	@PostMapping("addinfo")
	public String addinfo(Record record) {
		int count=sbiz.addRecord(record);
		if(count>0) {
			System.out.println("新增成功！");
		}else {
			System.out.println("新增失败！");
		}
		return "redirect:/c/students/getRecordList?p=1&s=2";
	}
	
	@RequestMapping("queryByStuCode")
	public String queryByStuCode(String stucode,Model model) {
		List<Record> list=sbiz.queryByStuCode(stucode);
		model.addAttribute("LIST",list);
		PageInfo<Student> pageInfo=sbiz.findStudentListByPage(1,2);
	    model.addAttribute("PAGE_INFO", pageInfo);
		return "student";
	}
	
	@PostMapping("queryByNameWithstuName")
	public String queryByNameWithStuName(Record record, Model model,Integer p, Integer s) {
		PageInfo<Record> data=sbiz.queryByNameWithStuName(1,2,record);
		if(data!=null) {
			model.addAttribute("PAGE_INFO", data);
		}
		return "info";
		}
	
	@RequestMapping("del")
	public String delByRecordById(Integer id) {
		System.out.println( "移除id:" + id);
		sbiz.removeByRecordId(id);
		return "redirect:/c/students/getRecordList?p=1&s=2";
	}
	
	@RequestMapping("load")
	public String queryById(Integer id, Model model) {
		Record record=sbiz.queryById(id);
		model.addAttribute("INFO",record);
		List<Student> list=sbiz.queryAllStudent();
		model.addAttribute("INFOS",list);
		return "update";
	}
	
	@RequestMapping("adminOut")
	public String adminOut(HttpSession session) {
		session.removeAttribute("USERS");
		session.invalidate();
		return "login";
	}
	
	
	@RequestMapping("updateinfo")
	public String update(Record record) {
		int count=sbiz.update(record);
		if(count>0) {
			System.out.println("修改成功！");
		}else {
			System.out.println("修改失败！");
		}
		return "redirect:/c/students/getRecordList?p=1&s=2";
	}
}

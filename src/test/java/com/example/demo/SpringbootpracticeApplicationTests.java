package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.biz.StudentBiz;
import com.example.demo.pojo.Record;
import com.example.demo.pojo.Student;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootpracticeApplicationTests {

	@Autowired
	private StudentBiz sBiz;
	
	@Test
	public void contextLoads() {
		System.out.println(sBiz.queryAllStudent());
	}

	
	@Test
	public void test01() {
		Student stu=new Student("admin","1");
		Student s=sBiz.queryByNameWithPwd(stu);
		if(s!=null) {
			System.out.println("成功！");
		}else {
			System.out.println("失败！");
		}
		
	}
	
	@Test
	public void test02() {
		Record record=new Record(null,null);
		PageInfo<Record> pages=sBiz.queryByNameWithStuName(1,2,record);
		System.out.println("123:"+pages);
		for (Record s : pages.getList()) {
			System.out.println(s.getCreateBy());
		}
	}

}

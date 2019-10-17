package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Record;
import com.example.demo.pojo.Student;

public interface IStudentDao {

	List<Student> queryAllStudent();
	
	Student queryByNameWithPwd(@Param("stu") Student stu);
	
	List<Record> queryAllRecord();
	
	Record queryById(Integer id);
	
	List<Record> queryByStuCode(String stucode);
	
	List<Record> queryByNameWithStuName(Record record);
	
	int delByRecordById(Integer id);
	
	int addRecord(Record record);
	
	int update(Record record);
}

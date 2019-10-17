package com.example.demo.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IStudentDao;
import com.example.demo.pojo.Record;
import com.example.demo.pojo.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class StudentBiz {

	@Autowired
	private IStudentDao sDao;
	
	public List<Student> queryAllStudent(){
		return sDao.queryAllStudent();
	}
	
	public Student queryByNameWithPwd(Student stu) {
		return sDao.queryByNameWithPwd(stu);
	}
	
	public PageInfo<Student> findStudentListByPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Student>(sDao.queryAllStudent());
	}
	
	public PageInfo<Record> findRecordListByPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Record>(sDao.queryAllRecord());
	}
	
	public List<Record> queryByStuCode(String stucode){
		return sDao.queryByStuCode(stucode);
	}
	
	public int removeByRecordId(Integer id) {
		return sDao.delByRecordById(id);
	}
	
	public int addRecord(Record record) {
		return sDao.addRecord(record);
	}
	
	public PageInfo<Record> queryByNameWithStuName(Integer pageNum,Integer pageSize,Record record) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Record>(sDao.queryByNameWithStuName(record));
	}
	
	public Record queryById(Integer id) {
		return sDao.queryById(id);
	}
	
	public int update(Record record) {
		return sDao.update(record);
	}
}

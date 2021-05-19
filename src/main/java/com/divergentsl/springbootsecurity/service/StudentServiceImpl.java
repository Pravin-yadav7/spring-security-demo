package com.divergentsl.springbootsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootsecurity.dao.BaseDao;
import com.divergentsl.springbootsecurity.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	//BaseDao<Student> studentDao = new StudentDaoImpl();
	/*//private StudentDaoImpl studentDao;

	public StudentServiceImpl() {//
	  //studentDao =  new StudentDao();
	}
*/
	@Autowired
	BaseDao<Student> studentDao;

	@Transactional
	@Override
	public void insert(Student student) {
		
		studentDao.insert(student);
		
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> findAll() {
		
		return studentDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Student find(int studentId) {
		
		return studentDao.find(studentId);
	}

	@Transactional
	@Override
	public void delete(int studentId) {
		
		studentDao.remove(studentId);
		
	}

	
}

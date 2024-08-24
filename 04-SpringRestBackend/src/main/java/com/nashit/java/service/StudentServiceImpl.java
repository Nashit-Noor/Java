package com.nashit.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashit.java.dao.StudentDao;
import com.nashit.java.entity.Student;
import com.nashit.java.entity.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;
	
	@Override
	public List<Student> getAll() {
		return dao.findAll();
	}

	@Override
	public Integer save(Student student) {
		student = dao.save(student);
		return student.getStudentId();
	}

	@Override
	public Student getById(Integer id) {
		return dao.findById(id).orElseThrow(
				()->new StudentNotFoundException("Student '"+id+"' Not exist")
				);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public void updateById(Student s) {
		if(s.getStudentId()==null || !dao.existsById(s.getStudentId())) {
			throw new StudentNotFoundException("Student '"+s.getStudentId()+"' Not exist");
		} else {
			dao.save(s);
		}
	}

}

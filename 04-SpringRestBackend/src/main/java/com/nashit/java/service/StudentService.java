package com.nashit.java.service;

import java.util.List;

import com.nashit.java.entity.Student;

public interface StudentService {

	List<Student> getAll();

	Integer save(Student student);

	Student getById(Integer id);

	void deleteById(Integer id);

	void updateById(Student s);

}

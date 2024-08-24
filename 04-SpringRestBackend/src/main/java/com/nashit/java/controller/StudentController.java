package com.nashit.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashit.java.entity.Student;
import com.nashit.java.service.StudentService;

@RestController
@RequestMapping("/v1/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Integer saveStudent(@RequestBody Student s) {
		return studentService.save(s);
	}
	
	@GetMapping("/all")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
	@GetMapping("/fetch/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return studentService.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteRecord(@PathVariable Integer id) {
		studentService.deleteById(id);
	}
	
	@PutMapping("/update")
	public void updateRecord(@RequestBody Student s) {
		studentService.updateById(s);
	}
	
}

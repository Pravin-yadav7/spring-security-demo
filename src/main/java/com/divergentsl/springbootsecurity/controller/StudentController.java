package com.divergentsl.springbootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.springbootsecurity.entity.Student;
import com.divergentsl.springbootsecurity.service.StudentService;

@RestController
@RequestMapping(path = "api/student", produces = "application/json")
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController() {
		super();
	}
	
	@GetMapping
	protected ResponseEntity<List<Student>> studentList() {
		
		List<Student> allStudent = studentService.findAll();
		return new ResponseEntity<List<Student>>(allStudent, HttpStatus.OK);	
	}
	
	@GetMapping("/{studentId}")
	private ResponseEntity<Student> find(@PathVariable int studentId) {
		Student student = studentService.find(studentId);

		if (student != null) {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		//return new ResponseEntity<Student>(null, HttpStatus.NOT_FOUND);
		return null;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Student student) {
		studentService.insert(student);
	}
	
	@DeleteMapping("/{studentId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int studentId) {
		studentService.delete(studentId);
	}
	
	
}

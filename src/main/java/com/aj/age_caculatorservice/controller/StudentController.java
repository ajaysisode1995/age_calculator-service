package com.aj.age_caculatorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aj.age_caculatorservice.entities.Student;
import com.aj.age_caculatorservice.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		student.calculateAge();
		Student saveStudentInDB=this.studentService.saveStudent(student);
		return new ResponseEntity<Student>(saveStudentInDB,HttpStatus.OK);
	}
	
	@PutMapping("/{id}/calculate-age")
	public ResponseEntity<Student> updateStudent(@PathVariable Long studentId){
		Student updatedStudent=this.studentService.updateStudent(studentId);
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> findAllStudent(){
		List<Student> list=this.studentService.findAllStudent();
		return new ResponseEntity<List<Student>>(list,HttpStatus.FOUND);
		
	}
	@GetMapping("/studentBetween18And25")
	public ResponseEntity<List<Student>> findAllStudentAgeBetween(){
		List<Student> list=this.studentService.getStudentsBetween18And25();
		return new ResponseEntity<List<Student>>(list,HttpStatus.FOUND);
		
	}
}

package com.aj.age_caculatorservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aj.age_caculatorservice.entities.Student;
import com.aj.age_caculatorservice.exceptions.StudentNotFoundException;
import com.aj.age_caculatorservice.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private  StudentRepository studentRepository ;
	
	
	public Student saveStudent(Student student) {
		return this.studentRepository.save(student);
	}
	
	
	public Student updateStudent(Long studentId) {
		Student studentFromDb=this.studentRepository
				.findById(studentId)
				.orElseThrow(()->new StudentNotFoundException("student with id "+studentId+"not found"));
		studentFromDb.calculateAge();
		return studentFromDb;
	}
	
	public List<Student> findAllStudent(){
		return this.studentRepository.findAll();
	}
	
	public List<Student> getStudentsBetween18And25(){
		return this.studentRepository.findStudentsBetween18And25();
		
	}
}

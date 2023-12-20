package com.aj.age_caculatorservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aj.age_caculatorservice.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

	@Query("SELECT s from Student s where s.age between 18 and 25")
	List<Student> findStudentsBetween18And25();
}

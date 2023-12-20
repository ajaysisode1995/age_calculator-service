package com.aj.age_caculatorservice.entities;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private int dayOfBirth;
	    private int monthOfBirth;
	    private int yearOfBirth;
	    private int age;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getDayOfBirth() {
			return dayOfBirth;
		}
		public void setDayOfBirth(int dayOfBirth) {
			this.dayOfBirth = dayOfBirth;
		}
		public int getMonthOfBirth() {
			return monthOfBirth;
		}
		public void setMonthOfBirth(int monthOfBirth) {
			this.monthOfBirth = monthOfBirth;
		}
		public int getYearOfBirth() {
			return yearOfBirth;
		}
		public void setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	    public Student() {
	    	
	    }
		public Student(Long id, String name, int dayOfBirth, int monthOfBirth, int yearOfBirth, int age) {
			super();
			this.id = id;
			this.name = name;
			this.dayOfBirth = dayOfBirth;
			this.monthOfBirth = monthOfBirth;
			this.yearOfBirth = yearOfBirth;
			this.age = age;
		}
		public void calculateAge() {
	        LocalDate currentDate = LocalDate.now();
	        LocalDate birthdate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);

	        Period period = Period.between(birthdate, currentDate);
	        this.age = period.getYears();
	    }

}

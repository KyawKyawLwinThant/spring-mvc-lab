package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Department;
import com.example.demo.entity.Province;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentCourse;
import com.example.demo.repository.ProvinceRepository;

@Service
public class StudentService {
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Transactional
	public void createDb() {
		Province p1=new Province("Sule");
		Province p2=new Province("Haling");
		
		Student student1=new Student("G11", "John Doe");
		Student student2=new Student("G11", "Thomas Hardy");
		
		Student student3=new Student("G10", "John William");
		Student student4=new Student("G10","John Updike");
		
		Department department1=new Department("CS");
		Department department2=new Department("SE");
		
		Course course1=new Course("Java", "101");
		Course course2=new Course("Python","102");
		Course course3=new Course("Ruby","103");
		
		p1.addStudnet(student1);
		p1.addStudnet(student2);
		
		p2.addStudnet(student3);
		p2.addStudnet(student4);
		
		department1.addStudent(student1);
		department1.addStudent(student2);
		department2.addStudent(student3);
		department2.addStudent(student4);
		
		//s1 - java - 95
		StudentCourse sc1=new StudentCourse(95);
		student1.addStudentCourses(sc1);
		course1.addStudentCourse(sc1);
		
		//s1 - python - 80
		StudentCourse sc2=new StudentCourse(80);
		student1.addStudentCourses(sc2);
		course2.addStudentCourse(sc2);
		
		//s1 - ruby - 90
		StudentCourse sc3=new StudentCourse(90);
		student1.addStudentCourses(sc3);
		course3.addStudentCourse(sc3);
		
		//s2 - java - 90
		StudentCourse sc4=new StudentCourse(90);
		student2.addStudentCourses(sc4);
		course1.addStudentCourse(sc4);
		
		//s3 -java - 80
		StudentCourse sc5=new StudentCourse(80);
		student3.addStudentCourses(sc5);
		course1.addStudentCourse(sc5);
		
		//s4 - java - 97
		StudentCourse sc6 = new StudentCourse(97);
		student4.addStudentCourses(sc6);
		course1.addStudentCourse(sc6);
		
		//s4 - python - 90
		StudentCourse sc7 = new StudentCourse(90);
		student4.addStudentCourses(sc7);
		course2.addStudentCourse(sc7);
		
		
		provinceRepository.save(p1);
		provinceRepository.save(p2);
		
		
	}

}










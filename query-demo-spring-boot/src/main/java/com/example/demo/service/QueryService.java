package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QueryService {
	private final StudentRepository studentRepository;
	
	//
	
	public void queryTest() {
		
		System.out.println("Students by provinceName::");
		studentRepository.findStudentsByProvinceName("Haling")
		.forEach(System.out::println);
		System.out.println();
		System.out.println("Province by StudentName::");
		studentRepository.getProvinceByStudentName("John Updike")
		.ifPresentOrElse(System.out::println,()->{
			System.out.println("Not Found!");
		});
		System.out.println();
		System.out.println("StudentInfo");
		studentRepository.getStudentInfo("Java")
		.forEach(System.out::println);
		System.out.println();
		System.out.println("Studentby FirstName and LastName:");
		studentRepository.findByName("John Doe")
		.ifPresentOrElse(System.out::println, ()->{
			System.out.println("Not Found Student::");
		});
		System.out.println("Search Student By Name");
		System.out.println(studentRepository.searchStudentByName("John Doe"));
		
		System.out.println("Courses By StudentName::");
		studentRepository.findAllCoursesByStudentName("John Updike")
		.forEach(System.out::println);
			
	}

}

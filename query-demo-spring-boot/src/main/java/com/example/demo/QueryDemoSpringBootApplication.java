package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.QueryService;
import com.example.demo.service.StudentService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class QueryDemoSpringBootApplication {
	
	private final StudentService studentService;
	
	private final QueryService queryService;
	
	@Bean
	public CommandLineRunner run() {
		return r ->{
			studentService.createDb();
			
			queryService.queryTest();
			
			JPAUtil.checkData("select * from province");
			JPAUtil.checkData("select * from student");
			JPAUtil.checkData("select * from department");
			JPAUtil.checkData("select * from course");
			JPAUtil.checkData("select * from student_course");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(QueryDemoSpringBootApplication.class, args);
	}

}

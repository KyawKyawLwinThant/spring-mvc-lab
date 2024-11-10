package com.example.demo.repository;

import com.example.demo.entity.Student;

public interface CustomQuery {
	Student searchStudentByName(String name);
}

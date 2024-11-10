package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse,Long> {

}

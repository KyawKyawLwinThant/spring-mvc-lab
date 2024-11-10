package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course extends IdClass {
	private String courseName;
	private String code;
	@OneToMany(mappedBy = "course")
	private List<StudentCourse> studentCourses=
			new ArrayList<>();
	public Course(String courseName, String code) {
		super();
		this.courseName = courseName;
		this.code = code;
	}
	
	public void addStudentCourse(StudentCourse studentCourse) {
		studentCourse.setCourse(this);
		studentCourses.add(studentCourse);
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", code=" + code + "]";
	}
	
	
	
	
	
}

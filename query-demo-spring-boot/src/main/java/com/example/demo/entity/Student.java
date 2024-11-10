package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends IdClass {
	private String matricNo;
	private String name;
	
	@ManyToOne
	private Province province;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Department department;
	
	@OneToMany(mappedBy = "student",
			cascade = CascadeType.PERSIST)
	private List<StudentCourse> studentCourses=
			new ArrayList<>();
	
	
	public Student(String matricNo, String name) {
		super();
		this.matricNo = matricNo;
		this.name = name;
	}
	
	public void addStudentCourses(StudentCourse studentCourse) {
		studentCourse.setStudent(this);
		studentCourses.add(studentCourse);
	}

	@Override
	public String toString() {
		return "Student [matricNo=" + matricNo + ", name=" + name + ", province=" + province.getProvinceName() + ", department="
				+ department.getDepName() + "]";
	}
	
	
	
}

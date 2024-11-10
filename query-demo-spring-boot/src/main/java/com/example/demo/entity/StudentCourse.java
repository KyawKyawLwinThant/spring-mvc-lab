package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class StudentCourse extends IdClass{
	
	private int marks;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Course course;
	@ManyToOne
	private Student student;

	public StudentCourse(int marks) {
		super();
		this.marks = marks;
	}
	
	

}

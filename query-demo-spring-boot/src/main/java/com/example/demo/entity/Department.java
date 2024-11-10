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
public class Department extends IdClass {
	
	private String depName;
	@OneToMany(mappedBy = "department")
	private List<Student> students=
			new ArrayList<>();

	public Department(String depName) {
		super();
		this.depName = depName;
	}
	
	public void addStudent(Student student) {
		student.setDepartment(this);
		students.add(student);
	}
	
	
}

package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Province extends IdClass{
	private String provinceName;
	
	@OneToMany(mappedBy = "province",
			cascade = CascadeType.PERSIST)
	private List<Student> students=
			new ArrayList<>();

	public Province(String provinceName) {
		super();
		this.provinceName = provinceName;
	}
	
	public void addStudnet(Student student) {
		student.setProvince(this);
		students.add(student);
	}

	@Override
	public String toString() {
		return "Province [provinceName=" + provinceName + "]";
	}
	
	
	
	
	
}

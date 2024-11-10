package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
@Repository
public class CustomQueryImpl implements CustomQuery{
	@Autowired
	private EntityManager em;

	@Override
	public Student searchStudentByName(String name) {
	
		return em.createQuery("select s from Student s where s.name = ?1", Student.class)
				.setParameter(1, name)
				.getSingleResult();
	}

}

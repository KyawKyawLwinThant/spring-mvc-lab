package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.StudentInfo;
import com.example.demo.entity.Course;
import com.example.demo.entity.Province;
import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>,CustomQuery {
	//'B%' '%Man%'
	Optional<Student> findByName(String name);
	
	@Query("select s from Student s where s.province.provinceName = ?1")
	List<Student> listAllStudentByProvince(String provinceName);
	
	
	@Query("""
			select c from Course c join c.studentCourses sc join sc.student s
			where s.name = ?1
			""")
	List<Course> findAllCoursesByStudentName(String studentName);
	
	@Query("""		
		select s from Student s 
		where s.province.provinceName = :pname
			""")
	List<Student> findStudentsByProvinceName(@Param("pname")String provinceName);
	
	@Query("select p from Province p join p.students s where s.name = :sname")
	Optional<Province> getProvinceByStudentName(@Param("sname")String studentName);
	
	@Query("""
			select new com.example.demo.dto.StudentInfo(p.provinceName,s.name,s.matricNo,d.depName,c.courseName,sc.marks) 
			from Province p join students s
			join s.department d join s.studentCourses sc join sc.course c
			where c.courseName = ?1 and sc.marks = (select max(scc.marks) from StudentCourse scc)
			""")
	List<StudentInfo> getStudentInfo(String courseName);

}

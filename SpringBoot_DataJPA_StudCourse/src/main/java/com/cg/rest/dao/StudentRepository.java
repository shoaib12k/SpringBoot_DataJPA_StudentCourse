package com.cg.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.rest.entity.Course;
import com.cg.rest.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query("Select c from Student s join s.courseList c where s.studentId = :studentId")
	public List<Course> findCoursesByStudenId(@Param(value = "studentId") int studentId);

}

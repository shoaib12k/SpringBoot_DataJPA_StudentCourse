package com.cg.rest.services;

import java.util.List;

import com.cg.rest.entity.Student;
import com.cg.rest.exception.NoSuchStudentFoundException;

public interface StudentService {
	
	Student addStudent(Student stud);
	List<Student> findAllStudents();
	Student findStudentById(int studentId) throws NoSuchStudentFoundException;
	Student updateStudent(int studentId, Student stud) throws NoSuchStudentFoundException;
	boolean deleteStudent(int studentId) throws NoSuchStudentFoundException;
	
}

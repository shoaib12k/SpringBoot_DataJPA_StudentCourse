package com.cg.rest.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.entity.Course;
import com.cg.rest.entity.Student;
import com.cg.rest.exception.NoSuchStudentFoundException;
import com.cg.rest.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studService;
	
	@PostMapping("/create-student")
	public ResponseEntity<Student> createNewStudent(@RequestBody Student stud){
		try {
			return new ResponseEntity<>(studService.addStudent(stud), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		try {
			List<Student> studList = studService.findAllStudents();
			if(studList.isEmpty())
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<>(studList, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId ){
		try {
			Student student = studService.findStudentById(studentId);
			return new ResponseEntity<>(student, HttpStatus.FOUND);
		}catch(NoSuchStudentFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update-student/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student updatedStud){
		try {
			return new ResponseEntity<>(studService.updateStudent(studentId, updatedStud), HttpStatus.ACCEPTED);
		}catch(NoSuchStudentFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete-student/{studentId}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("studentId") int studentId){
		try {
			return new ResponseEntity<>(studService.deleteStudent(studentId), HttpStatus.OK);
		}catch(NoSuchStudentFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/courses/student/{id}")
	public ResponseEntity<List<Course>> getCourseByStudentId(@PathVariable("id") int id){
		try {
			return new ResponseEntity<>(studService.findCoursesByStudenId(id), HttpStatus.FOUND);
			
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

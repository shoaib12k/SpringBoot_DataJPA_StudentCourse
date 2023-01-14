package com.cg.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rest.dao.StudentRepository;
import com.cg.rest.entity.Student;
import com.cg.rest.exception.NoSuchStudentFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studRepo;
	
	@Override
	public Student addStudent(Student stud) {
		return studRepo.save(stud);
	}

	@Override
	public List<Student> findAllStudents() {
		return studRepo.findAll();
	}

	@Override
	public Student findStudentById(int studentId) throws NoSuchStudentFoundException{
		Optional<Student> findStud  = studRepo.findById(studentId);
		
		if(findStud.isPresent())
			return findStud.get();
		else
			throw new NoSuchStudentFoundException("No Student With this ID");
	}

	@Override
	public Student updateStudent(int studentId, Student stud) throws NoSuchStudentFoundException{
		
		Student studToUpdate = findStudentById(studentId);
		
		studToUpdate.setStudentId(stud.getStudentId());
		studToUpdate.setStudentName(stud.getStudentName());
		studToUpdate.setCourse(stud.getCourse());
		
		return studToUpdate;
	}

	@Override
	public boolean deleteStudent(int studentId) throws NoSuchStudentFoundException{

		Student studToDelete = findStudentById(studentId);
		if(studToDelete == null)
			return false;
		else {
			studRepo.deleteById(studentId);
			return true;
		}
	}

}

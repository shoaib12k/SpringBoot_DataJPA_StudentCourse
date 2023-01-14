package com.cg.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rest.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}

package com.cg.rest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Scope("prototype")
@Table(name="Student_SB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;
	
	@Autowired
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> courseList;
}

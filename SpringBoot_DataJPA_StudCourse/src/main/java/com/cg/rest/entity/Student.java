package com.cg.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Student_SB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	private int studentId;
	private String studentName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Course course;
}

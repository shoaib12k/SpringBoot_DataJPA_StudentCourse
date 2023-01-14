package com.cg.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Course_SB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course{
	
	@Id
	private int courseId;
	private String courseName;
	private double courseFees;
	

}

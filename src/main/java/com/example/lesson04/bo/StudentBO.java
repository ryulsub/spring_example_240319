package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	// input: Student
	// output: X
	public void addStudent(Student student) {
		
		
	}
}

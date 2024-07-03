package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	// input: 파라미터 4개
	// output: StudentEntity
	public StudentEntity addStudent(String name,
			String phoneNumber, String email, String dreamjob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamjob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략 가능.
				.build();
				
		return studentRepository.save(student);
	}
	
	// input: Student
	// output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// update
	// input: id, dreamJob
	// output: StudentEntity or null
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터 조회 => StudentEntity
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// 엔티티의 데이터 값을 변경해 놓는다.
		if (student != null) {
			student = student.toBuilder()	// toBuilder는 기존 필드값은 유지하고 일부만 변경
					.dreamJob(dreamJob)
					.build();	// 꼭 객체에 다시 저장!
			
			// update
			// save 요청
			student = studentRepository.save(student);
		}
		
		return student;
	}
	
	// input: id
	// output: Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	
	// input: id
	// output: x
	public void deleteStudentById(int id) {
		// 방법1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법2)
		Optional<StudentEntity> studentOptional =  studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
		
	}
}
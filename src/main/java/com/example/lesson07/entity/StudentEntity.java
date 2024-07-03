package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체 출력 시 필드 값들이 보인다.
@AllArgsConstructor // 모든 파라미터 있는 생성자
@NoArgsConstructor	// 파라미터 없는 생성자
@Builder(toBuilder = true)	// setter를 대신해서 내용을 담음, toBuilder=true 필드 수정 허용
@Getter
@Table(name = "new_student")
@Entity	// 이 객체는 엔티티다. BO-JPA-DB 
public class StudentEntity {
	@Id // pk 식별자 등록
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert시 방금 들어간 id 가져옴
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamjob")
	private String dreamJob;
	
	@CreationTimestamp // 시간 값이 없어도 현재 시간으로 들어감, 업데이트시 변경 x
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // update시 시간 변경됨
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}

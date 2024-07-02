package com.example.lesson04.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
	private int id;
	private String name;
	private String yyyymmdd;
	private String introduce;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}

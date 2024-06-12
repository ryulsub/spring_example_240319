package com.example.lesson02.domain;

import java.time.LocalDateTime;

// 일반 자바 bean
// DTO, modal, domain, Entity
public class UsedGoods {
	private int id;
	private int sellerId;
	private String title;
	private String description;
	private int price;
	private String pictureUrl;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public int getId() {
		return Id;
	}
}

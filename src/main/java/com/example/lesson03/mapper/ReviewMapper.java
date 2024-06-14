package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	
	// input:X  output:Review or null
	public Review selectReviewById(int id);
}

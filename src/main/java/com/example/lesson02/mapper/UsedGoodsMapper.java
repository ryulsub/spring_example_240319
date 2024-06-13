package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper
public interface UsedGoodsMapper {
	
	// input: (BO로 붙어 받아옴) X
	// output: (BO한테 전달) List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
	
}

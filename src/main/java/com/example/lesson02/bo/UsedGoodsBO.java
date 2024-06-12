package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service	// spring bean
public class UsedGoodsBO {
	
	// input: X (컨트롤러로부터 들어온 요청)
	// output: (Repository한테 받은 것을) List<UsedGoods> (컨트롤러한테 줌) 
	public List<UsedGoods> getUsedGoodsList() {
		
	}
	
	
}

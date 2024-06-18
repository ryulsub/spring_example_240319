package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

import ch.qos.logback.core.model.Model;

@RequestMapping("/lesson04/ex01")
@Controller // html 화면의 경우 @ResponseBody 사용안함
public class Lesson04Ex01Controller {
	
	// 회원가입 화면
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // html view 경로
	}
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 진행 => DB 저장 => 결과화면
	@PostMapping("/add-user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// DB 저장 - insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 결과 화면
		return "lesson04/afterAddUser";
	}
	
	// 최근 가입자 뿌리는 화면
	// http://localhost/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) { // Model: view화면에서 
		// DB select (최신 가입자 1명)
		User user = userBO.getLatestUser();
		
		// Model 주머니에 담는다. => HTML에서 꺼내쓴다.
		model.addAttribute("result", user);
		model.addAttribute("title","최근 가입한 유저 정보!");
		
		// 화면 이동
		return "lesson04/latestUser";
	}
	
}

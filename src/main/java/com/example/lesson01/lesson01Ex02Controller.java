package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 보내는 컨트롤러 용도로 씀
@Controller  // @ResponseBody가 있으면 안 된다!!!
public class lesson01Ex02Controller {

	// http://localhost/lesson01/ex02
	@RequestMapping("lesson01/ex02")
	public String ex02() {
		// return 되는 String은 html의 경로이다. (@ResponseBody가 없을 때)
		
		// return "			  lesson01/ex02  ";
		// return "/templates/lesson01/ex02.html"
		return "lesson01/ex02";	// response html view 경로
	}
	
}

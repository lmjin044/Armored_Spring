package com.example.test1.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

/*
 JSP MVC 패턴 주소 맵핑
  - 주소패턴과 서블렛 클래스 연결(web.xml)
  - 주소 패턴이 다양하면 서블렛 클래스의 갯수도 늘어난다.
  - 주소 요청을 처리할 메서드 지정을 위한 map, poperties와 같이
    주소와 메서드를 1:1 지정하여 처리하기 위한 객체 or 파일이 필요
  - 어떤 주소요청인지 파악하기 위한 코드와 실행코드를 작성할 것
  	




 스프링에서 주소 맵핑(요청 주소- 처리내용 간 연결 작업)
  - @Controller를 클래스에 지정
  -요청방식에 따른 주소를 매핑 (@GetMapping("/주소명")
  -요청 주소를 처리할 메서드 정의와 반환값으로 보여줄 페이지 이름 지정	
  -이 방식으로 사용하면 주소 형식과 연결할 것을 지정하는 것을 매우 간단히 구현 가능
   
 */

	
	@GetMapping("/test")
	public String testFirst() {
		return "test";
	}
	
	@GetMapping("/aaa.g")
	public String testSec() {
		return "login";
	}
	
//	@GetMapping("signUp")
//	public String testtrd() {
//		return "/member/signUp";
//	}
	
//문제 : 주소요청은 /signUp. 
//		뷰 페이지는 member/signUp.jsp
//		뷰 페이지 내용에는 : 아이디, 비밀번호, 연락처, 생년월일을 입력할 것
	
	@PostMapping("/signUp")	//받는 방식이 get과 post 중 어떤 것이냐에 따라 선택해서 하자.
	public String signUpSave(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("tel") String tel,
			@RequestParam("birth") String birth) {
		System.out.println(id);
		
		return "member/signUp";
	}
	//괄호 안에 가져올 것을 형식과 매개변수로 함께 지정하면 같이 가져온다. 
	//또 다른 방법 : java bin 방식의 이용
	/*
	  1)클래스 인스턴스 변수를 input의 name과 일치시킨다.
	  2)클래스의 생성자 메서드가 필요
	  3)인스턴스 변수의 get-set
	  4)인스턴스 변수의 제어자를 private로 고정할 것
	  
	 
	 */
	
	
}

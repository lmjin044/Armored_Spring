package com.example.test1.control;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.test1.DTO.MemberDto;
import com.example.test1.DTO.loginDto;

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
	
	@GetMapping("signUp")
	public String testtrd() {
		return "/member/signUp";
	}
	
//문제 : 주소요청은 /signUp. 
//		뷰 페이지는 member/signUp.jsp
//		뷰 페이지 내용에는 : 아이디, 비밀번호, 연락처, 생년월일을 입력할 것
	
	
//	@PostMapping("/signUp")	//받는 방식이 get과 post 중 어떤 것이냐에 따라 선택해서 하자.
//	public String signUpSave(
//			@RequestParam("id") String id,
//			@RequestParam("pw") String pw,
//			@RequestParam("tel") String tel,
//			@RequestParam("birth") String birth) {
//		System.out.println(id);
//		
//		return "member/signUp";
	//}
	//방법 1 : 괄호 안에 가져올 것을 형식과 매개변수로 함께 지정하면 같이 가져온다. 
	
	
	
	
	//또 다른 방법 : java bin 방식의 이용
	/*
	  1)클래스 인스턴스 변수를 input의 name과 일치시킨다.
	  2)클래스의 생성자 메서드가 필요
	  3)인스턴스 변수의 get-set
	  4)인스턴스 변수의 제어자를 private로 고정할 것
	 */
	
//	@PostMapping("/signUp")
//	public String signUpSave(@ModelAttribute MemberDto memberDto) {
//		//소괄호 안에 위 에트리뷰트와 dto클래스 및 변수 명을 지정하면된다.
//		System.out.println("두번째 방법 : " + memberDto.getId());
//		
//		return "member/signUp";
//	}
	
//이제 3번째 방법 : 범용! 어떤 폼데이터도 클래스 추가없이 자바 내장 기능으로 가져올 수있다
// 단점은 데이터베이스 저장이 좀 거시기 함. 데이터베이스 저장 측면은 두번째 버전을 쓰는게 더 나음
	
	@PostMapping("/signUp")
	public String signUpSave(@RequestParam Map<String, String> pm) {
		//받아올 정보와 보낼 정보의 파라미터 키와 밸류를 pm의 변수명으로 저장
		System.out.println("세번째 방법 : "+ pm.get("id"));
		return "member/signUp";
	}
	
//문제 : javabin 방식으로 form 데이터 만들것.
// 조건 : 1. 아이디와 비밀번호가 있는 로그인 페이지를 만들고 로그인 버튼을 클릭할 것
/*
  		DTO 클래스 : loginDto.
  		뷰페이지 : login.jsp(로그인 폼 페이지) = get 방식 (/login)
  				 loginResult.jsp(로그인 후 보여줄 페이지) = post 방식(/login)
  				 	>> <a href ="/test">페이지 이동<a> 방식
  */	
	
	@GetMapping("/login")
	public String loginInfo() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String memberInfo(@ModelAttribute loginDto loginDto) {
		System.out.println("아이디는? " +loginDto.getUserId()+" 비밀번호는? : "+loginDto.getUserPw());
		return "member/loginResult";
	}
	
	
	@GetMapping("/")
	public ModelAndView home() {
		//스프링 프레임 워크에 존재하는 뷰페이지와 데이터를 동시에 제공하는 클래스
		String title = "여름 휴가는 어디로?";
		ModelAndView mv = new ModelAndView("index");
			//모델앤뷰 클래스는 객체를 생성하며 괄호 안에 뷰페이지 
		mv.addObject("pageTitle", title);
			//이러면 title 변수에 있는 내용을 index.jsp에 title 이름으로 전송 가능
			//이때 전송은 index 페이지에서 EL태그로 지정하면 된다. 
		
		return mv;
	}
	
	
	
	
	
	
}

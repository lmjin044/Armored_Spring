package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.BankDto;
import com.example.bookTest.Dto.InfoDto;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String homeView () {
		//같은 이름으로 메서드를 구성하려면 오버로딩 해야 한다.
		//뷰 페이지만 넘겨줄 거면 페이지 이름만 넘기면 된다.
		//(application.properties에서 이미 설정했으므로. 
		return "home";
	}
	
	@GetMapping("/infoInput")
	public ModelAndView info(@ModelAttribute InfoDto infoDto) {
		ModelAndView mv = new ModelAndView("info");
		
		String byear = infoDto.getUBirth().substring(0,4);
		int age = 2024-Integer.parseInt(byear);
		mv.addObject("ageData", age);
			//뷰페이지에 전달할 새로운 데이터를 설정
			//이렇게 할 경우 띄우려면 ${ageData}를 입력하면 됨
		
		return mv;
		//반환타입으로 모델앤뷰를 표시할 경우 : 사용자에게 데이터를 보여줘야 할 때
		//사용자에게 제공할 페이지 : 객체 생성시 입력하거나 setViewName 메서드로 입력
	}
	
	
	@GetMapping("/input")
	public String bank() {
		return "bank";
	}

   	
	
	@PostMapping("/result")
	public ModelAndView result(@ModelAttribute BankDto bankDto) {
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("data", bankDto);
		
		return mv;
	}
}

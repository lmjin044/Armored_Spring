package com.example.movieAndgame.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movieAndgame.Dto.MovieMember;
import com.example.movieAndgame.Service.MovieMemberService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	public MovieMemberService movieMemberService;
	
	//여기서 "/" = localhost/movie/index
	@GetMapping("/index")
	public String Home() {
	
		return "movie/index";
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) {
		model.addAttribute("member", new MovieMember());
		
		return "movie/member/login";
	}
	
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("movieMember", new MovieMember());
		
		return "movie/member/join";
	}
	
	@PostMapping("/signUp")
	public String signUp(@Valid MovieMember movieMember, 
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println("유효하지 않은 값 입력");
			
			return "movie/member/join";
		}
		boolean isDup=movieMemberService.signUpSave(movieMember);
		if(isDup) {//이메일이 중복이라면 회원가입 페이지로 이동한다.
			bindingResult.rejectValue("email", "error.email", "이미 사용중인 이메일 입니다.");
			return "movie/member/join";
		}
		movieMemberService.signUpSave(movieMember);
		return "redirect:/movie/login";
	}
	
	
	//로그인 처리 요청
	@PostMapping("/signIn")
	public String signIn(MovieMember member, HttpSession session, Model model) {
		//DB에서 이메일+비번이 일치하는지 확인 > 일치하면 세션을 만들어 첫 페이지로, 그렇지 않으면 로그인페이지로.
	
		MovieMember user = movieMemberService.login(member);
		if(user==null) {
			//로그인 실패의 경우
			model.addAttribute("member", member);
			model.addAttribute("fail", "a");
			return "redirect:/movie/login";
		}
		
		session.setAttribute("user", user);
		
		return"redirect:/movie/index";
	}
	
	@GetMapping("/logout")
	public String out(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/movie/index";
	}
	
}

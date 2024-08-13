package com.example.movieAndgame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movieAndgame.Dto.MovieMember;

@Controller
@RequestMapping("/movie")
public class MovieController {

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
	
	
}

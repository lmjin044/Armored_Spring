package com.example.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movieAndgame.Dto.MovieMember;
import com.example.movieAndgame.Dto.MovieReviewDto;
import com.example.movieAndgame.Service.MovieReviewService;

@Controller
@RequestMapping("/movieMenu")
public class MovieMenuControl {

	@Autowired
	private MovieReviewService reviewService;
	
	//글 내용 작성 후 저장 요청하기
	@GetMapping("/write")
	public String reviewWrtie(@Valid MovieReviewDto movieReviewDto, BindingResult bind, Model model) {
		if(bind.hasErrors()) {
			return "movie/review/write";
		}
		
		reviewService.save(movieReviewDto);
		return "redirect:/movieMenu/review";
	}
	
	@GetMapping("/review")
	public String reviewMain(Model model) {
		return "movie/review/index";
	}
	//리뷰작성 페이지 요청
	@GetMapping("/reviewWrite")
	public String write(Model model, HttpSession session) {
	
		if(session.getAttribute("user")==null) {
			return "redirect:/movie/login";
		}
		
		MovieReviewDto dto = new MovieReviewDto();
		String name = ((MovieMember)session.getAttribute("user")).getName();
		dto.setWriter(name);
		
		model.addAttribute("movieReviewDto", dto);
		return "movie/review/write";	
	}
}
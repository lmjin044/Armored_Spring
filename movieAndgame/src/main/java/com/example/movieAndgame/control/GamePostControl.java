package com.example.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movieAndgame.Dto.GameMember;
import com.example.movieAndgame.Dto.GameReviewDto;
import com.example.movieAndgame.Service.GameReviewService;

@Controller
@RequestMapping("/gamePost")
public class GamePostControl {
	@Autowired
	private GameReviewService reviewService;
	
	@GetMapping("/post")
	public String reivewWrite(@Valid GameReviewDto gameReviewDto, BindingResult bind, Model model) {
		if(bind.hasErrors()) {
			return "game/post/m";
		}
		
		reviewService.save(gameReviewDto);
		return "redirect:/gamePost/index";
	}
	
	@GetMapping("/reivew")
	public String reviewMain(Model model) {
		return "game/post/index";
	}
	
	@GetMapping("/postWrite")
	public String write(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/game/login";
		}
		
		GameReviewDto dto = new GameReviewDto();
		String nickname = ((GameMember)session.getAttribute("user")).getNickname();
		dto.setWriter(nickname);
		
		model.addAttribute("gameReviewDto", dto);
		return "game/review/m";
	}
	
}

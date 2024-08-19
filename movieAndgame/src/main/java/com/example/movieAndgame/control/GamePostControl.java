package com.example.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movieAndgame.Dto.GameMember;
import com.example.movieAndgame.Dto.GameReviewDto;
import com.example.movieAndgame.Service.GameReviewService;

@Controller
@RequestMapping("/gamePost")
public class GamePostControl {
	@Autowired
	private GameReviewService gameReviewService;
	
	
	@GetMapping("/m")
	public String reviewMain(Model model) {
		return "game/post/index";
	}
	
	
	@GetMapping("/postWrite")
	public String write(Model model, HttpSession session) {
		if(session.getAttribute("user") ==null) {
			return "redirect:/game/login";
		}
		
		GameReviewDto dto= new GameReviewDto();
		String name=((GameMember)session.getAttribute("user")).getNickname();
		dto.setWriter(name);
		
		model.addAttribute("gameReviewDto", dto);
		return "game/post/gamewrite";
	}
	
	
	@PostMapping("/postWrite")
	public String write(@Valid GameReviewDto gameReviewDto, BindingResult bindingResult, Model model) {
	    if(bindingResult.hasErrors()) {
	        // 기존 작성 페이지로 돌아가면서 에러 메시지를 표시
	        return "game/post/gamewrite";
	    }
	    
	    // 인스턴스를 통해 서비스 메서드 호출
	    gameReviewService.review(gameReviewDto);
	    return "redirect:/gamePost/m";
	}
}


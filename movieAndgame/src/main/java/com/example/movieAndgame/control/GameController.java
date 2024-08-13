package com.example.movieAndgame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movieAndgame.Dto.GameMember;

@Controller
@RequestMapping("/game")
public class GameController {

	@GetMapping("/index")
	public String home(Model model) {

		return "game/index";
	}

	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("gameMember" , new GameMember());		
		return "game/member/login";
	}
	
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("", model);
		
		return "game/member/signUp";
	}
	
}

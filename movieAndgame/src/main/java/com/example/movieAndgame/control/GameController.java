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
import com.example.movieAndgame.Dto.MovieMember;
import com.example.movieAndgame.Service.GameMemberService;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	public GameMemberService gameMemberService;
	
	@GetMapping("/index")
	public String home(Model model) {

		return "game/index";
	}

	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("member" , new GameMember());		
		return "game/member/login";
	}
	
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("gameMember", new GameMember());
		
		return "game/member/signUp";
	}
	
	@PostMapping("/signUp")
	public String signUp(@Valid GameMember gameMember, 
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println("유효하지 않은 값 입력");
			
			return "game/member/signUp";
		}
		boolean isDup=gameMemberService.signUpSave(gameMember);
		if(isDup) {
			bindingResult.rejectValue("email", "error.email", "이미사용중인 이메일입니다.");
			return "game/member/signUp";
		}
		
		gameMemberService.signUpSave(gameMember);
		return "redirect:/game/login";
	}

	@PostMapping("/signIn")
	public String signIn(GameMember member, HttpSession session, Model model) {
		GameMember user=gameMemberService.login(member);
		if(user==null) {
			model.addAttribute("member", member);
			model.addAttribute("fail", "a");
			return "redirect:/game/login";
		}
		session.setAttribute("user", user);
		return "redirect:/game/index";
	}
	
	@GetMapping("/logout")
	public String out(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/game/index";
	}
	
}

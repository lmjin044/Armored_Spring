package com.example.test1.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.test1.DTO.BoardDto;

@Controller
//컨트롤러로 쓰려면 이거 꼭 있어야 함
public class BoardController {

	@GetMapping("/board")
	public ModelAndView boardHome() {
		ModelAndView mav = new ModelAndView();
		//페이지와 데이터를 동시에 제공하는 목적으로 쓰는거다!
		mav.setViewName("/board/boardList");
		return mav;
		
	}
	
	
	@GetMapping("/boardWrite")
	public String boardWrite(){
		return "/board/write";
	} 

	
	
/*
혹은 
	@GetMapping("/boardWrite")
	public ModelAndView boardWrite() {
		ModelAndView write = new ModelAndView();
		write.setViewName("/board/write");
		return write;
		}
로 해도 된다.
 */	
	
	
	
	
	@PostMapping("/view")
		//여긴 action으로 받은 내용을 옮겨줘야 하는 자리야
	public ModelAndView write(@ModelAttribute BoardDto boardDto) {
		ModelAndView mv = new ModelAndView("board/view");
		mv.addObject("data", boardDto);
		
		return mv;
	}	
//		@RequestParam("title") String title, 
//		@RequestParam("writer") String writer, 
//		@RequestParam("content") String content, 
//		@RequestParam("boardPw") String boardPw) {
//	ModelAndView view = new ModelAndView();
//	view.addObject("title", title);
//	view.addObject("writer", writer);
//	view.addObject("content", content);
//	view.setViewName("/board/view");
	
/*
문제 : 
	1)글쓰기를 클릭해 게시글 작성 페이지로 이동
	2)작성 버튼을 클릭하면 게시글 보기 페이지로 이동 및 작성 내용을 출력할 것
	3)각 페이지로 이동하기 위한 Mapping과 뷰페이지의 데이터 출력 방법을 작성 
 
  
  
 */
	
	
	
}

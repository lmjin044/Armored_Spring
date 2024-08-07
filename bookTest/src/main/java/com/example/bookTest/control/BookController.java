package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.BookDto;
import com.example.bookTest.Dto.BookInfoDto;

@Controller
public class BookController {

	@GetMapping("/write")
	public String book() {
		return "bookWrite";
	}
	
	@GetMapping("/bookDetail")
	public ModelAndView bookInfo(@ModelAttribute BookInfoDto bookDto) {
		ModelAndView mv = new ModelAndView("detail");
		mv.addObject("data", bookDto);
		return mv;
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/bookWrite")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView("/book/bookForm");
		mv.addObject("count", 5);
		return mv;
	}
	
	@PostMapping("/enroll")
	public String write(@ModelAttribute BookDto bookDto) {
		return "index";
	}
}

package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.BookDto;
import com.example.bookTest.Dto.BookInfoDto;
import com.example.bookTest.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public ModelAndView home() {
			ModelAndView mv = new ModelAndView("index");
			List<BookDto> list = bookService.selectAll();
			mv.addObject("list", list);
	return mv;	
	}
	
	@GetMapping("/bookWrite")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView("/book/bookForm");
		mv.addObject("count", 5);
		return mv;
	}
	
	@PostMapping("/enroll")
	public String write(@ModelAttribute BookDto bookDto) {
		bookService.BookSave(bookDto);
		//만약 숫자 변환을 시키고 싶으면 여기서 requestparam을 사용해야 함
		//그리고 엔터를 눌러서 엉뚱한 값을 그래도 전송되는 것을 막으려면 자바스크립트로 해야함
		return "index";
		
	}
	
	
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
	
	

	
	
}

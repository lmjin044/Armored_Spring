package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/book/view")
	public ModelAndView view(@RequestParam(value = "id", 
							required = false, defaultValue="0")int id ) {
		BookDto data = bookService.getBook(id);
		if(data == null) data = new BookDto();	
			//getBook메서드의 변환값으로 null이 저장되면?
			//view.jsp에서 변수의 값이 null이므로 get 메서드 호출이 안 되어 어류 발생
			//오류 발생이 되지 않도록 빈 값이 있는 객체를 할당하기.
		
		return new ModelAndView("/book/view").addObject("book",data);
	}
	
	@GetMapping("/book/delete")
	public String bookRemove(@RequestParam("id")int bid) {
			
		bookService.remove(bid);
		return "redirect:/";
		
		//return "<script> alert('삭제되었습니다.'); location.href='/' </script>";
		// ㄴ이건 삭제 메시지 알람이 뜨면서 삭제 되는거고.
	}
	
	@GetMapping("/book/update")
	public String bookUpdate(@ModelAttribute BookDto bookDto,
			@RequestParam("id")int id) {
		bookDto.setBookId(id);
		bookService.update(bookDto);
		
		return "redirect:/book/view?id="+id;
		//수정된 도서의 상세페이지로 이동
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

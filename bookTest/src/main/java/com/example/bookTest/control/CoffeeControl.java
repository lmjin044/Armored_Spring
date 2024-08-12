package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.CoffeeDto;
import com.example.bookTest.service.CoffeeService;

@Controller
public class CoffeeControl {

	@Autowired
	public CoffeeService coffeeService;
	
	
	@GetMapping("/coffee/index")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("coffee/index");
		List<CoffeeDto> list = coffeeService.selectAll();
		mv.addObject("list",list);
		return mv;
	}
	
	
	@PostMapping("/coffeeReg")
	public String coffe(@ModelAttribute CoffeeDto coffeeDto) {
		coffeeService.CoffeeSave(coffeeDto);
		return "redirect:/coffee";
	}
	
	
	@GetMapping("coffeeReg")
	public String coffeReg() {
		return "coffee/coffeeReg";
		
	}
	
	@GetMapping("/coffee/view")
	public ModelAndView view(
			@RequestParam(value="id", required=false, defaultValue="0")
			int id){
			CoffeeDto data=coffeeService.getCoffee(id);
			if(data==null) data=new CoffeeDto();
	
	return new ModelAndView("/coffee/view").addObject("coffee",data);
	}
	
	@GetMapping("/coffee/delete")
	public String coffeeRemove(@RequestParam("id")int cid) {
		coffeeService.remove(cid);
		return "redirect:/coffee/index";
	}
	
	@GetMapping("/coffee/update")
	public String coffeeUpdate(@ModelAttribute CoffeeDto coffeeDto,
			@RequestParam("id")int id) {
		coffeeDto.setCoffeeId(id);
		coffeeService.update(coffeeDto);
		
		return "redirect:/coffee/view?id="+id;
	}
	
	
}

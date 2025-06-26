package kr.or.ddit.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 등록 페이지와 등록 기능
@Controller
@RequestMapping("/book")
public class BookInsertController {
	
	// Book 게시판 등록 페이지
	@GetMapping("/form.do")
	public ModelAndView bookForm() {
		return new ModelAndView("book/form");
	}
}

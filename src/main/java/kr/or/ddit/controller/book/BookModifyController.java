package kr.or.ddit.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Book 수정 페이지와 수정 기능
@Controller
@RequestMapping("/book")
public class BookModifyController {

	// Book 게시판 수정 페이지
	@GetMapping("/update.do")
	public ModelAndView updateBookForm() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("book/update");
		return mav;
	}
	
}

package kr.or.ddit.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 목록과 상세 정보를 확인할 컨트롤러
@Controller
@RequestMapping("/book")
public class BookRetrieveController {
	
	// Book 게시판 목록 페이지
	@GetMapping("/list.do")
	public ModelAndView listBook() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("book/list");
		return mav;
	}
	
	@GetMapping("/detail.do")
	public ModelAndView detail() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("book/detail");
		return mav;
	}
}

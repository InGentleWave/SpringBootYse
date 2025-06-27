package kr.or.ddit.controller.book;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.IBookService;

// 목록과 상세 정보를 확인할 컨트롤러
@Controller
@RequestMapping("/book")
public class BookRetrieveController {
	
	@Autowired
	private IBookService bookService;
	
	// Book 게시판 목록 페이지
	@GetMapping("/list.do")
	public ModelAndView listBook(@RequestParam Map<String,Object> map) {
		ModelAndView mav = new ModelAndView();
		
		List<Map<String,Object>> list = bookService.selectBookList(map);
		
		if(map.containsKey("keyword")) {	// 검색 함
			mav.addObject("keyword", map.get("keyword"));
		}
		mav.addObject("bookList",list);
		mav.setViewName("book/list");
		return mav;
	}
	
	@GetMapping("/detail.do")
	public ModelAndView detail(@RequestParam Map<String,Object> map) {
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> detailMap = bookService.selectBook(map);
		
		// ModelAndView 객체 mav에 뷰로 전달할 데이터를 담는다.
		// book이라는 키의 이름으로 쿼리의 결과를 담았다.(bookId와 일치하는 1개의 책 정보)
		mav.addObject("book",detailMap);
		
		// 쿼리스트링으로 전달된 bookId(PK)를 detail로 함께 전달한다.
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId",bookId);
		mav.setViewName("book/detail");
		return mav;
	}
}

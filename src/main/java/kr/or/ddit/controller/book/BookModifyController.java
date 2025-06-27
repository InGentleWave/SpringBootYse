package kr.or.ddit.controller.book;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.SpringBootYseApplication;
import kr.or.ddit.service.IBookService;

// Book 수정 페이지와 수정 기능
@Controller
@RequestMapping("/book")
public class BookModifyController {

    private final SpringBootYseApplication springBootYseApplication;

	@Autowired
	private IBookService bookService;

    BookModifyController(SpringBootYseApplication springBootYseApplication) {
        this.springBootYseApplication = springBootYseApplication;
    }
	
	// Book 게시판 수정 페이지
	@GetMapping("/update.do")
	public ModelAndView updateBookForm(@RequestParam Map<String,Object> map) {
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> detailMap = bookService.selectBook(map);
		mav.addObject("book",detailMap);
		mav.setViewName("book/update");
		return mav;
	}
	
	@PostMapping("/update.do")
	public ModelAndView updateBook(@RequestParam Map<String, Object> map) {
		/*
			{
				"bookId" : 3,
				"title" : "제목 수정",
				"category" : "내용 수정",
				"price" : 15000
			}
		 */
		ModelAndView mav = new ModelAndView();
		
		boolean isUpdateSuccess = bookService.updateBook(map);
		if(isUpdateSuccess) {	// 수정 성공
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId="+bookId);
		} else {				// 수정 실패
			// 갱신이 되지 않았을 경우, GET 메소드로 redirect 하는 방법도 있지만,
			// 상세보기 화면을 바로 보여 줄 수도 있습니다.
			mav = updateBookForm(map);
		}
		
		return mav;
	}
	
	@PostMapping("/delete.do")
	public ModelAndView deleteBook(@RequestParam Map<String,Object> map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isDeleteSuccess = bookService.deleteBook(map);
		if(isDeleteSuccess) {	// 삭제 성공
			mav.setViewName("redirect:/book/list.do");
		} else {				// 삭제 실패
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId="+bookId);
		}
		
		return mav;
		
	}
	
}
